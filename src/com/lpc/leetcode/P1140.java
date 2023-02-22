package com.lpc.leetcode;

/**
 * 石子游戏 II
 *
 * @author byu_rself
 * @date 2023/2/22 11:34
 */
public class P1140 {

    public int stoneGameII(int[] piles) {
        int n = piles.length, sum = 0;
        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= n; M++) {
                if (i + 2 * M >= n) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
