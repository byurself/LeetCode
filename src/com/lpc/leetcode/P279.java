package com.lpc.leetcode;

/**
 * 完全平方数
 *
 * @author byu_rself
 * @date 2022/10/17 11:29
 */
public class P279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i >= j * j; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
