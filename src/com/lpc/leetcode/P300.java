package com.lpc.leetcode;

/**
 * 最长递增子序列
 *
 * @author byu_rself
 * @date 2023/4/20 19:16
 */
public class P300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) f[i] = Math.max(f[i], f[j]);
            }
            ans = Math.max(ans, ++f[i]);
        }
        return ans;
    }

    /*int[] nums, cache;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        cache = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    private int dfs(int i) {
        if (cache[i] > 0) return cache[i];
        for (int j = 0; j < i; ++j) {
            if (nums[j] < nums[i]) cache[i] = Math.max(cache[i], dfs(j));
        }
        return ++cache[i];
    }*/
}
