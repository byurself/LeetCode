package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长重复子串
 *
 * @author byu_rself
 * @date 2023/5/15 9:56
 */
public class P1044 {

    long[] h, p;
    static int hash = 1313131;
    int n;

    public String longestDupSubstring(String s) {
        n = s.length();
        h = new long[n + 1];
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 0; i < n; ++i) {
            p[i + 1] = p[i] * hash;
            h[i + 1] = h[i] * hash + s.charAt(i);
        }
        String ans = "";
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            String t = check(s, mid);
            if (t.length() != 0) l = mid;
            else r = mid - 1;
            ans = t.length() > ans.length() ? t : ans;
        }
        return ans;
    }

    private String check(String s, int length) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + length - 1 <= n; ++i) {
            int j = i + length - 1;
            long cur = h[j] - h[i - 1] * p[j - i + 1];
            if (set.contains(cur)) return s.substring(i - 1, j);
            set.add(cur);
        }
        return "";
    }
}
