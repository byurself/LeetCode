package com.lpc.leetcode;

/**
 * 寻找峰值II
 *
 * @author byu_rself
 * @date 2023/12/19 11:01
 */
public class P1901 {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int left = 0, right = m - 1;
        while (left < right) {
            int i = left + right >> 1;
            int j = maxPos(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) right = i;
            else left = i + 1;
        }
        return new int[]{left, maxPos(mat[left])};
    }

    private int maxPos(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[p] < nums[i]) {
                p = i;
            }
        }
        return p;
    }
}
