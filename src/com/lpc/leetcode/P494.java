package com.lpc.leetcode;

/**
 * 目标和
 *
 * @author byu_rself
 * @date 2022/10/15 13:15
 */
public class P494 {

    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) ans++;
        } else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }
}
