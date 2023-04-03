package com.lpc.leetcode;

import java.util.*;

/**
 * 打开转盘锁
 *
 * @author byu_rself
 * @date 2023/4/3 13:34
 */
public class P752 {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);
        visited.add("0000");

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (deadSet.contains(cur)) continue;
                if (q2.contains(cur)) return step;
                visited.add(cur);
                for (int j = 0; j < 4; ++j) {
                    String next1 = upOne(cur, j);
                    String next2 = downOne(cur, j);
                    if (!visited.contains(next1)) temp.add(next1);
                    if (!visited.contains(next2)) temp.add(next2);
                }
            }
            ++step;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public int openLock1(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();

        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.poll();
                if (deadSet.contains(cur)) continue;
                if (cur.equals(target)) return step;

                for (int j = 0; j < 4; ++j) {
                    String next1 = upOne(cur, j);
                    String next2 = downOne(cur, j);
                    if (!visited.contains(next1)) {
                        queue.offer(next1);
                        visited.add(next1);
                    }
                    if (!visited.contains(next2)) {
                        queue.offer(next2);
                        visited.add(next2);
                    }
                }
            }
            ++step;
        }
        return -1;
    }

    // 将 s[i] 向上拨动一次
    private String upOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') ch[i] = '0';
        else ch[i]++;

        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    private String downOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') ch[i] = '9';
        else ch[i]--;
        return new String(ch);
    }
}
