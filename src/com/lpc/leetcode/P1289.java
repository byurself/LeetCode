package com.lpc.leetcode;

/**
 * 下降路径最小和II
 *
 * @author byu_rself
 * @date 2023/8/10 9:34
 */
public class P1289 {

    public int minFallingPathSum(int[][] grid) {
        // f: 前 i 行的最小数字和 s: 前 i 行的第二小数字和 idx: 第 i 行的最小数字的所在列号
        int f = 0, s = 0, idx = -1;
        for (int[] row : grid) {
            int ff = Integer.MAX_VALUE, ss = Integer.MAX_VALUE, t = -1;
            for (int j = 0; j < row.length; ++j) {
                int sum = (j == idx ? s : f) + row[j];
                if (sum < ff) {
                    ss = ff;
                    ff = sum;
                    t = j;
                } else if (sum < ss){
                    ss = sum;
                }
            }
            f = ff;
            s = ss;
            idx = t;
        }
        return f;
    }

    public int minFallingPathSum1(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        System.arraycopy(grid[0], 0, f[0], 0, n);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (j != k) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][k] + grid[i][j]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : f[n - 1]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}
