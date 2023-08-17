package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 切披萨的方案数
 *
 * @author byu_rself
 * @date 2023/8/17 9:40
 */
public class P1444 {

    public static final int MOD = (int) 1e9 + 7;
    int[][][] cache;
    int m, n;
    MatrixSum ms;

    public int ways(String[] pizza, int k) {
        ms = new MatrixSum(pizza);
        m = pizza.length;
        n = pizza[0].length();
        cache = new int[k][m][n];
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < m; ++j) {
                Arrays.fill(cache[i][j], -1); // -1 表示没有计算过
            }
        }
        return dfs(k - 1, 0, 0);
    }

    private int dfs(int c, int i, int j) {
        // 无法再切了
        if (c == 0) return ms.query(i, j, m, n) > 0 ? 1 : 0;
        if (cache[c][i][j] != -1) return cache[c][i][j];
        int ans = 0;
        // 垂直切
        for (int j2 = j; j2 < n; ++j2) {
            // 有苹果
            if (ms.query(i, j, m, j2) > 0) {
                ans = (ans + dfs(c - 1, i, j2)) % MOD;
            }
        }
        // 水平切
        for (int i2 = i; i2 < m; ++i2) {
            // 有苹果
            if (ms.query(i, j, i2, n) > 0) {
                ans = (ans + dfs(c - 1, i2, j)) % MOD;
            }
        }
        return cache[c][i][j] = ans;
    }

    // 二维前缀和模板（'A' 的 ASCII 码最低位为 1，'.' 的 ASCII 码最低位为 0）
    private static class MatrixSum {
        private final int[][] sum;

        public MatrixSum(String[] matrix) {
            int m = matrix.length, n = matrix[0].length();
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) & 1);
                }
            }
        }

        public int query(int r1, int c1, int r2, int c2) {
            return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
        }
    }
}

    /*public static final int MOD = (int) 1e9 + 7;

    public int ways(String[] pizza, int k) {
        MatrixSum ms = new MatrixSum(pizza);
        return dfs(k - 1, 0, 0, ms, pizza.length, pizza[0].length());
    }

    private int dfs(int c, int i, int j, MatrixSum ms, int m, int n) {
        // 无法再切了
        if (c == 0) return ms.query(i, j, m, n) > 0 ? 1 : 0;
        int ans = 0;
        // 垂直切
        for (int j2 = j; j2 < n; ++j2) {
            // 有苹果
            if (ms.query(i, j, m, j2) > 0) {
                ans = (ans + dfs(c - 1, i, j2, ms, m, n)) % MOD;
            }
        }
        // 水平切
        for (int i2 = i; i2 < m; ++i2) {
            // 有苹果
            if (ms.query(i, j, i2, n) > 0) {
                ans = (ans + dfs(c - 1, i2, j, ms, m, n)) % MOD;
            }
        }
        return ans;
    }

    // 二维前缀和模板（'A' 的 ASCII 码最低位为 1，'.' 的 ASCII 码最低位为 0）
    private static class MatrixSum {

        private final int[][] sum;

        public MatrixSum(String[] matrix) {
            int m = matrix.length, n = matrix[0].length();
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (matrix[i].charAt(j) & 1);
                }
            }
        }

        public int query(int r1, int c1, int r2, int c2) {
            return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
        }
    }*/
}


