package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 划分为k个相等的子集
 *
 * @author byu_rself
 * @date 2022/9/20 10:48
 */
public class P698 {

    int[] nums;
    boolean[] visited;
    int n, target, k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % k != 0) return false;
        this.nums = nums;
        n = nums.length;
        this.k = k;
        Arrays.sort(nums);
        visited = new boolean[n];
        target = total / k;
        return dfs(n - 1, 0, 0);
    }

    private boolean dfs(int idx, int cur, int cnt) {
        if (cnt == k) return true;
        if (cur == target) return dfs(n - 1, 0, cnt + 1);
        for (int i = idx; i >= 0; --i) {
            if (visited[i] || cur + nums[i] > target) continue;
            visited[i] = true;
            if (dfs(i - 1, cur + nums[i], cnt)) return true;
            visited[i] = false;
            if (cur == 0) return false;
        }
        return false;
    }

    /*private int[] nums;
    private boolean[] visited;
    private int n, t, k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int total = 0;
        for (int x : nums) total += x;
        if (total % k != 0) return false;
        Arrays.sort(nums);
        n = nums.length;
        visited = new boolean[n];
        t = total / k;
        return dfs(n - 1, 0, 0);
    }

    private boolean dfs(int idx, int cur, int cnt) {
        if (cnt == k) return true;
        if (cur == t) return dfs(n - 1, 0, cnt + 1);
        if (idx == -1) return false;
        for (int i = idx; i >= 0; i--) {
            if (visited[i] || cur + nums[i] > t) continue;
            visited[i] = true;
            if (dfs(i - 1, cur + nums[i], cnt)) return true;
            visited[i] = false;
            if (cur == 0) return false;
        }
        return false;
    }*/
}
