package com.lpc.leetcode;

/**
 * 重复叠加字符串匹配
 *
 * @author byu_rself
 * @date 2023/3/27 21:58
 */
public class P686 {

    public int repeatedStringMatch(String a, String b) {
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
    }
}
