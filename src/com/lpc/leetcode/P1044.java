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

    static final int hash = 1313131;
    long[] h, p;
    int n;

    public String longestDupSubstring(String s) {
        n = s.length();
        h = new long[n + 1]; // 哈希数组
        p = new long[n + 1]; // 次方数组
        p[0] = 1;
        for (int i = 1; i <= n; ++i) {
            p[i] = p[i - 1] * hash;
            h[i] = h[i - 1] * hash + s.charAt(i - 1);
        }
        String ans = "";
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            String t = check(s, mid);
            if (!t.isEmpty()) left = mid;
            else right = mid - 1;
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
