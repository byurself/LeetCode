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
        String end = "AACCGCTA";
        String[] bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {
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
    }
}
