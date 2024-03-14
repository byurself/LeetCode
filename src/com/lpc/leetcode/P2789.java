package com.lpc.leetcode;

/**
 * 合并后数组中的最大元素
 *
 * @author byu_rself
 * @date 2024/3/14 9:13
 */
public class P2789 {

    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long sum = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            sum = nums[i] <= sum ? sum + nums[i] : nums[i];
        }
        return sum;
    }
}
