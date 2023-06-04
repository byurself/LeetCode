package com.lpc.leetcode;

/**
 * 两个字符串的删除操作
 *
 * @author byu_rself
 * @date 2023/6/4 13:56
 */
public class P583 {

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) f[i][0] = i;
        for (int j = 1; j <= m; ++j) f[0][j] = j;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                }
            }
        }
        return f[n][m];
    }

    public int minDistance1(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        // 求最长公共子序列 (LC.P1143)
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
                }
            }
        }
        int lcs = f[n][m];
        return n - lcs + m - lcs;
    }
}
