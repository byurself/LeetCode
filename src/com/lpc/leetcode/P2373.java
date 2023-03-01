package com.lpc.leetcode;

/**
 * 矩阵中的局部最大值
 *
 * @author byu_rself
 * @date 2023/3/1 12:16
 */
public class P2373 {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i + 1 < n - 1; i++) {
            for (int j = 0; j + 1 < n - 1; j++) {
                int max = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }
}
