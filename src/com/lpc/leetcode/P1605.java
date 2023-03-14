package com.lpc.leetcode;

/**
 * 给定行和列的和求可行矩阵
 *
 * @author byu_rself
 * @date 2023/3/14 10:51
 */
public class P1605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] ans = new int[m][n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            int rs = rowSum[i], cs = colSum[j];
            if (rs < cs) {
                colSum[j] -= rs;
                ans[i++][j] = rs;
            } else {
                rowSum[i] -= cs;
                ans[i][j++] = cs;
            }
        }
        return ans;
    }

    public int[][] restoreMatrix1(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}
