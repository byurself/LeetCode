package com.lpc.leetcode;

import org.junit.Test;

/**
 * 乘积小于 K 的子数组
 *
 * @author byu_rself
 * @date 2022/8/22 13:49
 */
public class Offer009 {

    @Test
    public void solution() {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, l = 0, prod = 1;
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (l <= r && prod >= k) prod /= nums[l++];
            ans += r - l + 1;
        }
        return ans;
    }
}
