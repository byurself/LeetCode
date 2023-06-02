package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 删除并获得点数
 *
 * @author byu_rself
 * @date 2023/6/2 9:19
 */
public class P740 {

    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum = new int[max + 1];
        for (int num : nums) sum[num] += num;
        int n = sum.length + 1;
        int first = sum[0], second = Math.max(sum[0], sum[1]);
        for (int i = 2; i < n; ++i) {
            int temp = second;
            second = Math.max(first + sum[i], second);
            first = temp;
        }
        return second;
    }

    public int deleteAndEarn1(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum = new int[max + 1];
        for (int num : nums) sum[num] += num;
        int n = sum.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = sum[0];
        for (int k = 2; k <= n; ++k) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + sum[k - 1]);
        }
        return dp[n];
    }
}
