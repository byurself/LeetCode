package com.lpc.leetcode;

/**
 * 有序三元组中的最大值II
 *
 * @author byu_rself
 * @date 2025/4/2 17:00
 */
public class P2874 {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int maxDiff = 0, leftMax = 0;
        for (int x : nums) {
            ans = Math.max(ans, (long) maxDiff * x);
            maxDiff = Math.max(maxDiff, leftMax - x);
            leftMax = Math.max(leftMax, x);
        }
        return ans;
    }

    /**
     * 贪心+前后缀数组
     */
    /*public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n]; // [0, i)的最大值
        int[] rightMax = new int[n]; // (i, n)的最大值

        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long ans = 0;
        for (int j = 1; j < n - 1; ++j) {
            ans = Math.max(ans, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }
        return ans;
    }*/
}
