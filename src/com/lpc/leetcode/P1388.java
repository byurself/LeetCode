package com.lpc.leetcode;

/**
 * 3n块披萨
 *
 * @author byu_rself
 * @date 2023/8/18 10:28
 */
public class P1388 {

    int n;

    public int maxSizeSlices(int[] slices) {
        n = slices.length / 3;
        int[] nums = new int[slices.length - 1];
        System.arraycopy(slices, 1, nums, 0, nums.length);
        int a = getMax(nums);
        System.arraycopy(slices, 0, nums, 0, nums.length);
        int b = getMax(nums);
        return Math.max(a, b);
    }

    private int getMax(int[] nums) {
        int m = nums.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = Math.max(f[i - 1][j], (i >= 2 ? f[i - 2][j - 1] : 0) + nums[i - 1]);
            }
        }
        return f[m][n];
    }
}
