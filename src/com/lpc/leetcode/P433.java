package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 最小基因变化
 *
 * @author byu_rself
 * @date 2022/5/7 10:44
 */
public class P433 {

    @Test
    public void solution() {
        String start = "AACCGGTT";
        String end = "CACCGGTT";
        String[] bank = new String[]{"CACCGGTT"};
        System.out.println(minMutation(start, end, bank));
    }

    Set<String> set;
    static char[] g = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        set = new HashSet<>(List.of(bank));
        if (!set.contains(endGene)) return -1;
        set.add(startGene);
        Deque<String> queue1 = new ArrayDeque<>(), queue2 = new ArrayDeque<>();
        queue1.offer(startGene);
        queue2.offer(endGene);
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        map1.put(startGene, 0);
        map2.put(endGene, 0);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int ans;
            if (queue1.size() <= queue2.size()) ans = bfs(queue1, map1, map2);
            else ans = bfs(queue2, map2, map1);
            if (ans != -1) return ans;
        }
        return -1;
    }

    private int bfs(Deque<String> queue, Map<String, Integer> map1, Map<String, Integer> map2) {
        int size = queue.size();
        while (size-- > 0) {
            String cur = queue.poll();
            char[] s = cur.toCharArray();
            int step = map1.get(cur);
            for (int i = 0; i < s.length; ++i) {
                char char0 = s[i];
                for (char c : g) {
                    if (s[i] == c) continue;
                    s[i] = c;
                    String cs = String.valueOf(s);
                    if (!set.contains(cs) || map1.containsKey(cs)) continue;
                    if (map2.containsKey(cs)) return map2.get(cs) + step + 1;
                    queue.offer(cs);
                    map1.put(cs, step + 1);
                }
                s[i] = char0;
            }
        }
        return -1;
    }

    // BFS
/*    public int minMutation2(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(List.of(bank));
        if (!set.contains(endGene)) return -1;
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        char[] g = new char[]{'A', 'C', 'G', 'T'};
        queue.offer(startGene);
        visited.add(startGene);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++ans;
            while (size-- > 0) {
                String cur = queue.poll();
                char[] s = cur.toCharArray();
                for (int i = 0; i < s.length; ++i) {
                    char char0 = s[i];
                    for (char c : g) {
                        if (s[i] == c) continue;
                        s[i] = c;
                        String cs = String.valueOf(s);
                        if (!set.contains(cs)) continue;
                        if (visited.contains(cs)) continue;
                        if (cs.equals(endGene)) return ans;
                        queue.offer(cs);
                        visited.add(cs);
                    }
                    s[i] = char0;
                }
            }
        }
        return -1;
    }

    public int minMutation1(String start, String end, String[] bank) {
        char[] items = new char[]{'A', 'C', 'G', 'T'};
        // 将bank去重，存入set
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Deque<String> deque = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        // 初始基因存入start
        deque.addLast(start);
        // map记录每一次新状态的步数
        map.put(start, 0);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String s = deque.pollFirst();
                char[] chars = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char c : items) {
                        if (chars[i] == c) continue;
                        char[] clone = chars.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub)) continue;
                        if (map.containsKey(sub)) continue;
                        if (sub.equals(end)) return ++step;
                        map.put(sub, step + 1);
                        deque.addLast(sub);
                    }
                }
            }
        }
        return -1;
    }*/
}
