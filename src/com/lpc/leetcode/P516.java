package com.lpc.leetcode;

/**
 * 最长回文子序列
 *
 * @author byu_rself
 * @date 2023/4/1 21:50
 */
public class P516 {

    public int longestPalindromeSubseq(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (s[i] == s[j]) f[i][j] = f[i + 1][j - 1] + 2;
                else f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][n - 1];
    }

    // 区间DP+记忆化搜索
    /*String s;
    int[][] cache;

    public int longestPalindromeSubseq1(String s) {
        this.s = s;
        int n = s.length();
        cache = new int[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) return 0; // 空串
        if (i == j) return 1; // 只有一个字母
        if (cache[i][j] != 0) return cache[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            cache[i][j] = dfs(i + 1, j - 1) + 2; // 都选
            return cache[i][j];
        }
        cache[i][j] = Math.max(dfs(i + 1, j), dfs(i, j - 1)); // 枚举哪个不选
        return cache[i][j];
    }*/
}
