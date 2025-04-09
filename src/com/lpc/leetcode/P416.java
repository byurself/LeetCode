package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 分割等和子集
 *
 * @author byu_rself
 * @date 2025/4/7 15:58
 */
public class P416 {
    private int[][] cache;
    private int[] nums;
    private int n;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) {
            return false;
        }
        this.n = nums.length;
        this.nums = nums;
        cache = new int[n][sum / 2 + 1];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return dfs(0, sum / 2);
    }

    private boolean dfs(int i, int s) {
        if (i >= n) {
            return s == 0;
        }
        if (cache[i][s] != -1) {
            return cache[i][s] == 1;
        }
        boolean res = (s >= nums[i] && dfs(i + 1, s - nums[i])) || dfs(i + 1, s);
        cache[i][s] = res ? 1 : 0;
        return res;
    }
}
