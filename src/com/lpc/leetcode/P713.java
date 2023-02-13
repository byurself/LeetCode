package com.lpc.leetcode;

import org.junit.Test;

/**
 * 乘积小于K的子数组
 *
 * @author byu_rself
 * @date 2022/5/5 8:44
 */
public class P713 {

    @Test
    public void solution() {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, n = nums.length;
        int p = 1;
        for (int l = 0, r = 0; r < n; r++) {
            p *= nums[r];
            while (l <= r && p >= k) {
                p /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int count = 0, product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

}
