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

    public String countOfAtoms(String s) {
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
    }
}
