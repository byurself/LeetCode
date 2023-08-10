package com.lpc.leetcode;

/**
 * 戳气球
 *
 * @author byu_rself
 * @date 2022/10/28 12:19
 */
public class P312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) arr[i] = nums[i - 1];
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; ++len) {
            for (int l = 0; l + len - 1 <= n + 1; ++l) {
                int r = l + len - 1;
                for (int k = l + 1; k <= r - 1; ++k) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + arr[l] * arr[k] * arr[r] + dp[k][r]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
