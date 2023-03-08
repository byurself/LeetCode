package com.lpc.leetcode;

import java.util.Arrays;

/**
 * K个逆序对数组
 *
 * @author byu_rself
 * @date 2023/3/8 13:47
 */
public class P629 {

    private final int MOD = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1], sum = new int[n + 1][k + 1];
        dp[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                dp[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + MOD) % MOD;
                sum[i][j] = j != 0 ? (sum[i][j - 1] + dp[i][j]) % MOD : dp[i][j];
            }
        }
        return dp[n][k];
    }
}
