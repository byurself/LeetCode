package com.lpc.leetcode;

/**
 * 最大的以 1 为边界的正方形
 *
 * @author byu_rself
 * @date 2023/2/17 14:30
 */
public class P1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) continue; // 为0，间断
                dp[i][j][0] = dp[i][j - 1][0] + 1; // 横向连续1的个数
                dp[i][j][1] = dp[i - 1][j][1] + 1; // 竖向连续1的个数
            }
        }
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cur = Math.min(dp[i][j][0], dp[i][j][1]);
                if (cur <= max) continue;
                while (cur > max) {
                    // 判断正方形左边和上边的长度是否大于cur
                    if (dp[i][j - cur + 1][1] >= cur && dp[i - cur + 1][j][0] >= cur) {
                        max = cur;
                        break;
                    }
                    cur--;
                }
            }
        }
        return max * max;
    }
}
