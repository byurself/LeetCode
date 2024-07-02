package com.lpc.leetcode;

/**
 * 质数的最大距离
 *
 * @author byu_rself
 * @date 2024/7/2 17:27
 */
public class P3115 {

    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            if (isPrime(nums[i])) {
                left = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (isPrime(nums[i])) {
                right = i;
                break;
            }
        }
        return right - left;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
