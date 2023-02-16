package com.lpc.leetcode;

/**
 * 递增的三元子序列
 *
 * @author byu_rself
 * @date 2023/2/16 20:10
 */
public class P334 {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int min = nums[0], mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > mid) return true;
            else if (num > min) mid = num;
            else min = num;
        }
        return false;
    }
}
