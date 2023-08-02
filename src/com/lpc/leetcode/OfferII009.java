package com.lpc.leetcode;

/**
 * 乘积小于K的子数组
 *
 * @author byu_rself
 * @date 2023/8/2 10:12
 */
public class OfferII009 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length, prod = 1, ans = 0;
        for (int left = 0, right = 0; right < n; ++right) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
