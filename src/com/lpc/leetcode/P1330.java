package com.lpc.leetcode;

/**
 * 翻转子数组得到最大的数组值
 *
 * @author byu_rself
 * @date 2023/5/12 9:34
 */
public class P1330 {

    public int maxValueAfterReverse(int[] nums) {
        int ans = 0, d = 0, n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int a = nums[i - 1], b = nums[i];
            int dab = Math.abs(a - b);
            ans += dab;
            max = Math.max(max, Math.min(a, b));
            min = Math.min(min, Math.max(a, b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - dab, Math.abs(nums[n - 1] - a) - dab));
        }
        return ans + Math.max(d, 2 * (max - min));
    }
}
