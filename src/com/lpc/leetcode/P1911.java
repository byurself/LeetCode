package com.lpc.leetcode;

/**
 * 最大子序列交替和
 *
 * @author byu_rself
 * @date 2023/7/11 11:21
 */
public class P1911 {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        // dp[i][0]表示以最后一个元素下标为偶数的子序列和
        // dp[i][1]表示以最后一个元素下标为奇数的子序列和
        long[][] dp = new long[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);
            }
        }
        // 最终选择的序列一定不可能位于奇数下标(因为奇数下标需要减去该值)
        return dp[n - 1][0];
    }
}
