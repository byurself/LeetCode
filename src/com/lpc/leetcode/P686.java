package com.lpc.leetcode;

/**
 * 重复叠加字符串匹配
 *
 * @author byu_rself
 * @date 2023/3/27 21:58
 */
public class P686 {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int ans = 0, n = a.length(), m = b.length();
        while (builder.length() < m) {
            builder.append(a);
            ++ans;
        }
        builder.append(a);
        int index = strStr(builder.toString(), b);
        if (index == -1) return -1;
        return index + m > n * ans ? ans + 1 : ans;
    }

    private int strStr(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        int[] next = new int[m + 1];
        for (int i = 1, j = 0; i < m; ) {
            if (j == 0 || p[i] == p[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        int i = 1, j = 1;
        while (i <= n && j <= m) {
            if (j == 0 || s[i] == p[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j > m) return i - m - 1;
        else return -1;
    }

/*    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            ++ans;
        }
        sb.append(a);
        int index = strStr(sb.toString(), b);
        if (index == -1) return -1;
        return index + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    public int strStr(String ss, String pp) {
        int m = ss.length(), n = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        int[] next = new int[n + 1];
        // 求next数组
        for (int i = 2, j = 0; i <= n; ++i) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j]; // 匹配不成功
            if (p[i] == p[j + 1]) ++j; // 匹配成功
            next[i] = j;
        }
        // 模式匹配
        for (int i = 1, j = 0; i <= m; ++i) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j]; // 匹配不成功
            if (s[i] == p[j + 1]) ++j; // 匹配成功
            if (j == n) return i - n; // 整串匹配成功
        }
        return -1;
    }*/
}
