package com.lpc.leetcode;

/**
 * 打家劫舍
 *
 * @author byu_rself
 * @date 2023/6/2 9:25
 */
public class P198 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= n; ++k) {
            // 1.偷前k-1个房间，第k个不偷
            // 2.偷前k-2个房间和最后一间
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k - 1]);
        }
        return dp[n];
    }
}
