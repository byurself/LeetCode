package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 原子的数量
 *
 * @author byu_rself
 * @date 2022/9/14 20:41
 */
public class P726 {

    @Test
    public void solution() {
        String s = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(s));
    }

    public String countOfAtoms(String formula) {
        int n = formula.length();
        char[] s = formula.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        int i = 0, index = 0;
        while (i < n) {
            char c = s[i];
            if (c == '(' || c == ')') {
                stack.push(String.valueOf(c));
                ++i;
            } else {
                if (Character.isDigit(c)) {
                    // 获取完整的数字
                    int j = i;
                    while (j < n && Character.isDigit(s[j])) ++j;
                    String number = formula.substring(i, j);
                    int cnt = Integer.parseInt(number);
                    i = j;

                    // 若栈顶为')'，则当前数值可以应用给连续一段原子中
                    if (!stack.isEmpty() && stack.peek().equals(")")) {
                        List<String> list = new ArrayList<>();
                        stack.pop(); // 弹出')'
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            String cur = stack.pop();
                            map.merge(cur, 1, (a, b) -> a * cnt);
                            // map.put(cur, map.getOrDefault(cur, 1) * cnt);
                            list.add(cur);
                        }
                        stack.pop(); // 弹出'('
                        for (int k = list.size() - 1; k >= 0; --k) {
                            stack.push(list.get(k));
                        }
                    } else {
                        // 栈顶不是')'，当前数值只能给栈顶的原子
                        String cur = stack.peek();
                        map.merge(cur, 1, (a, b) -> a * cnt);
                        // map.put(cur, map.getOrDefault(cur, 1) * cnt);
                    }
                } else {
                    // 获取完整的原子名
                    int j = i + 1;
                    while (j < n && Character.isLowerCase(s[j])) ++j;
                    String cur = formula.substring(i, j) + "_" + index++;
                    map.merge(cur, 1, Integer::sum);
                    i = j;
                    stack.push(cur);
                }
            }
        }

        // 将不同编号的相同原子进行合并
        Map<String, Node> m = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int cnt = entry.getValue();
            String atom = key.split("_")[0];
            Node node = null;
            if (m.containsKey(atom)) node = m.get(atom);
            else node = new Node(atom, 0);
            node.v += cnt;
            m.put(atom, node);
        }

        // 使用优先队列对Node进行字典序排序并构造答案
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.k.compareTo(b.k));
        for (String atom : m.keySet()) q.offer(m.get(atom));
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            Node cur = q.poll();
            builder.append(cur.k);
            if (cur.v > 1) builder.append(cur.v);
        }
        return builder.toString();
    }

    private static class Node {
        private String k;
        private int v;

        public Node(String k, int v) {
            this.k = k;
            this.v = v;
        }
    }

/*    public String countOfAtoms(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; ) {
            char c = cs[i];
            if (c == '(' || c == ')') {
                stack.push(String.valueOf(c));
                i++;
            } else {
                if (Character.isDigit(c)) {
                    // 获取完整的数字，并解析出对应的数值
                    int j = i;
                    while (j < n && Character.isDigit(cs[j])) j++;
                    String numStr = s.substring(i, j);
                    i = j;
                    int cnt = Integer.parseInt(numStr);

                    // 如果栈顶元素是 )，说明当前数值可以应用给「连续一段」的原子中
                    if (!stack.isEmpty() && stack.peek().equals(")")) {
                        List<String> tmp = new ArrayList<>();

                        stack.pop(); // pop )
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            String cur = stack.pop();
                            map.put(cur, map.getOrDefault(cur, 1) * cnt);
                            tmp.add(cur);
                        }
                        stack.pop(); // pop (

                        for (int k = tmp.size() - 1; k >= 0; k--) {
                            stack.push(tmp.get(k));
                        }

                        // 如果栈顶元素不是 )，说明当前数值只能应用给栈顶的原子
                    } else {
                        String cur = stack.pop();
                        map.put(cur, map.getOrDefault(cur, 1) * cnt);
                        stack.push(cur);
                    }
                } else {
                    // 获取完整的原子名
                    int j = i + 1;
                    while (j < n && Character.isLowerCase(cs[j])) j++;
                    String cur = s.substring(i, j) + "_" + idx++;
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                    i = j;
                    stack.push(cur);
                }
            }
        }

        // 将不同编号的相同原子进行合并
        Map<String, Node> mm = new HashMap<>();
        for (String key : map.keySet()) {
            String atom = key.split("_")[0];
            int cnt = map.get(key);
            Node node = null;
            if (mm.containsKey(atom)) {
                node = mm.get(atom);
            } else {
                node = new Node(atom, 0);
            }
            node.v += cnt;
            mm.put(atom, node);
        }

        // 使用优先队列（堆）对 Node 进行字典序排序，并构造答案
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.s.compareTo(b.s));
        for (String atom : mm.keySet()) q.add(mm.get(atom));

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node poll = q.poll();
            sb.append(poll.s);
            if (poll.v > 1) sb.append(poll.v);
        }

        return sb.toString();
    }

    private static class Node {
        private String s;
        private int v;

        Node(String _s, int _v) {
            s = _s;
            v = _v;
        }
    }*/
}
