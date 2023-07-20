package com.lpc.leetcode;

/**
 * 环形子数组的最大和
 *
 * @author byu_rself
 * @date 2023/7/20 9:45
 */
public class P918 {

    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // 最大子数组和，不能为空
        int minSum = 0; // 最小子数组和，可以为空
        int maxPre = 0, minPre = 0, sum = 0;
        for (int x : nums) {
            // 以 nums[i-1] 结尾的子数组选或不选（取 max）+ x = 以 x 结尾的最大子数组和
            maxPre = Math.max(maxPre, 0) + x;
            maxSum = Math.max(maxSum, maxPre);
            // 以 nums[i-1] 结尾的子数组选或不选（取 min）+ x = 以 x 结尾的最小子数组和
            minPre = Math.min(minPre, 0) + x;
            minSum = Math.min(minSum, minPre);
            sum += x;
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
