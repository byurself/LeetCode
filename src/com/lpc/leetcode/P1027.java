package com.lpc.leetcode;

/**
 * 最长等差数列
 *
 * @author byu_rself
 * @date 2023/4/22 14:37
 */
public class P1027 {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] f = new int[n][1001]; // f[i][j]表示以nums[i]结尾且公差为j的等差数列的最大长度
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = nums[i] - nums[j] + 500; // 防止负数
                f[i][d] = Math.max(f[i][d], f[j][d] + 1);
                ans = Math.max(ans, f[i][d]);
            }
        }
        return ans + 1;
    }
}
