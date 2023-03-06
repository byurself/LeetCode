package com.lpc.leetcode;

/**
 * 区域和检索 - 数组不可变
 *
 * @author byu_rself
 * @date 2023/3/6 14:45
 */
public class P303 {

    private int[] sum;

    public P303(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left];
    }
}
