package com.lpc.leetcode;

/**
 * 打家劫舍II
 *
 * @author byu_rself
 * @date 2023/9/17 21:22
 */
public class P213 {

    public int rob(int[] nums) {
        int n = nums.length;
        // 1.偷 nums[0]，那么 nums[1] 和 nums[n - 1] 不能偷，问题变成从 nums[2] 到 nums[n - 2] 的非环形版本
        // 2.不偷 nums[0]，那么问题变成 nums[1] 到nums[n - 1] 的非环形版本
        return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n - 1));
    }

    // LC.P198 打家劫舍
    private int rob1(int[] nums, int start, int end) { // [start,end) 左闭右开
        int f0 = 0, f1 = 0;
        for (int i = start; i < end; ++i) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
