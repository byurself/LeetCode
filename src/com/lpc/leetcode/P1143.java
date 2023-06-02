package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * @author byu_rself
 * @date 2023/6/3 0:34
 */
public class P1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[n][m];
    }

    char[] s1, s2;
    int[][] cache;

    public int longestCommonSubsequence1(String text1, String text2) {
        s1 = text1.toCharArray();
        s2 = text2.toCharArray();
        int n = s1.length, m = s2.length;
        cache = new int[n][m];
        for (int i = 0; i < n; ++i) Arrays.fill(cache[i], -1);
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        if (s1[i] == s2[j]) return cache[i][j] = dfs(i - 1, j - 1) + 1;
        else return cache[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
}
