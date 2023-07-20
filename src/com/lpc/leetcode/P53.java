package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最大子数组和
 *
 * @author byu_rself
 * @date 2022/5/24 9:32
 */
public class P53 {

    @Test
    public void solution() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (f[i - 1] > 0) f[i] = f[i - 1] + nums[i];
            else f[i] = nums[i];
        }
        int ans = f[0];
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int maxSubArray1(int[] nums) {
        int pre = 0, ans = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
