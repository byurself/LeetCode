package com.lpc.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 任意子数组和的绝对值的最大值
 *
 * @author byu_rself
 * @date 2023/8/8 9:14
 */
public class P1749 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum(nums));
    }

    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, fMax = 0, fMin = 0;
        for (int num : nums) {
            fMax = Math.max(fMax, 0) + num;
            fMin = Math.min(fMin, 0) + num;
            ans = Math.max(ans, Math.max(fMax, Math.abs(fMin)));
        }
        return ans;
    }

    public int maxAbsoluteSum1(int[] nums) {
        int n = nums.length, ans = Math.abs(nums[0]);
        int[] f = new int[n], g = new int[n];
        f[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            f[i] = Math.max(f[i - 1], 0) + nums[i];
            g[i] = Math.min(g[i - 1], 0) + nums[i];
            ans = Math.max(ans, Math.max(f[i], Math.abs(g[i])));
        }
        return ans;
    }
}
