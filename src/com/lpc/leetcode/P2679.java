package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 矩阵中的和
 *
 * @author byu_rself
 * @date 2023/7/4 9:29
 */
public class P2679 {

    public int matrixSum(int[][] nums){
        int ans = 0, m = nums.length, n = nums[0].length;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        for (int j = 0; j < n; ++j) {
            int max = 0;
            for (int i = 0; i < m; ++i) {
                max = Math.max(max, nums[i][j]);
            }
            ans += max;
        }
        return ans;
    }

    public int matrixSum1(int[][] nums) {
        int ans = 0, m = nums.length, n = nums[0].length;
        int[] score = new int[m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int maxIndex = 0;
                for (int k = 0; k < n; ++k) {
                    if (nums[j][maxIndex] < nums[j][k]) {
                        maxIndex = k;
                    }
                }
                score[j] = nums[j][maxIndex];
                nums[j][maxIndex] = -1;
            }
            int max = 0;
            for (int s : score) {
                if (max < s) max = s;
            }
            ans += max;
        }
        return ans;
    }
}
