package com.lpc.leetcode;

import java.util.*;

/**
 * 执行操作后字典序最小的字符串
 *
 * @author byu_rself
 * @date 2023/3/19 14:11
 */
public class P1625 {

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        String ans = s;
        int n = s.length();
        q.offer(s);
        set.add(s);
        while (!q.isEmpty()) {
            s = q.poll();
            if (ans.compareTo(s) > 0) ans = s;
            char[] cs = s.toCharArray();
            for (int i = 1; i < n; i += 2) {
                cs[i] = (char) (((cs[i] - '0' + a)) % 10 + '0');
            }
            String s1 = String.valueOf(cs);
            String s2 = s.substring(b) + s.substring(0, b);
            if (set.add(s1)) q.offer(s1);
            if (set.add(s2)) q.offer(s2);
        }
        return ans;
    }
}
