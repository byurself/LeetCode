package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 下降路径最小和
 *
 * @author byu_rself
 * @date 2023/7/13 9:31
 */
public class P931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n][n + 2]; // 防止 col = -1 || col = n 的越界情况
        System.arraycopy(matrix[0], 0, f[0], 1, n);
        for (int row = 1; row < n; ++row) {
            f[row - 1][0] = f[row - 1][n + 1] = Integer.MAX_VALUE;
            for (int col = 0; col < n; ++col) {
                f[row][col + 1] = Math.min(Math.min(f[row - 1][col], f[row - 1][col + 1]), f[row - 1][col + 2]) + matrix[row][col];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int col = 1; col <= n; ++col) {
            ans = Math.min(ans, f[n - 1][col]);
        }
        return ans;
    }

    // 记忆化搜索
    /*int[][] matrix;
    int[][] cache;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, ans = Integer.MAX_VALUE;
        this.matrix = matrix;
        cache = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(cache[i], Integer.MIN_VALUE);
        }

        for (int col = 0; col < n; ++col) {
            ans = Math.min(ans, dfs(n - 1, col));
        }
        return ans;
    }

    private int dfs(int row, int col) {
        if (col < 0 || col >= matrix.length) return Integer.MAX_VALUE; // 越界
        if (row == 0) return matrix[0][col]; // 到达第一行
        if (cache[row][col] != Integer.MIN_VALUE) return cache[row][col];
        return cache[row][col] = Math.min(Math.min(dfs(row - 1, col - 1), dfs(row - 1, col)), dfs(row - 1, col + 1)) + matrix[row][col];
    }*/

    // DFS(超时)
    /*int[][] matrix;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, ans = Integer.MAX_VALUE;
        this.matrix = matrix;
        for (int col = 0; col < n; ++col) {
            ans = Math.min(ans, dfs(n - 1, col));
        }
        return ans;
    }

    private int dfs(int row, int col) {
        if (col < 0 || col >= matrix.length) return Integer.MAX_VALUE; // 越界
        if (row == 0) return matrix[0][col]; // 到达第一行
        return Math.min(Math.min(dfs(row - 1, col - 1), dfs(row - 1, col)), dfs(row - 1, col + 1)) + matrix[row][col];
    }*/
}
