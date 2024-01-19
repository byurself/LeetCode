package com.lpc.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 使数组和小于等于x的最少时间
 *
 * @author byu_rself
 * @date 2024/1/19 11:05
 */
public class P2809 {

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] f = new int[n + 1][n + 1];
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; ++i) {
            nums[i] = new int[]{nums1.get(i), nums2.get(i)};
        }
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (j > 0) {
                    int a = nums[i - 1][0], b = nums[i - 1][1];
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + a + b * j);
                }
            }
        }
        int s1 = 0, s2 = 0;
        for (int v : nums1) s1 += v;
        for (int v : nums2) s2 += v;
        for (int j = 0; j <= n; ++j) {
            if (s1 + s2 * j - f[n][j] <= x) {
                return j;
            }
        }
        return -1;
    }
}
