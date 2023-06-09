package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 目标和
 *
 * @author byu_rself
 * @date 2022/10/15 13:15
 */
public class P494 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    // 动态规划优化
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, s = 0;
        for (int num : nums) s += Math.abs(num);
        if (target > s || (s - target) % 2 != 0) return 0;
        int m = (s - target) / 2;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            int num = nums[i - 1];
            for (int j = 0; j <= m; ++j) {
                f[i][j] += f[i - 1][j];
                if (j >= num) f[i][j] += f[i - 1][j - num];
            }
        }
        return f[n][m];
    }

    // 动态规划
    /*public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, offset = 0;
        for (int num : nums) offset += Math.abs(num);
        if (Math.abs(target) > offset) return 0;
        int[][] f = new int[n + 1][2 * offset + 1];
        f[0][offset] = 1;
        for (int i = 1; i <= n; ++i) {
            int num = nums[i - 1];
            for (int j = -offset; j <= offset; ++j) {
                if (j - num + offset >= 0) f[i][j + offset] += f[i - 1][j - num + offset];
                if (j + num + offset <= 2 * offset) f[i][j + offset] += f[i - 1][j + num + offset];
            }
        }
        return f[n][target + offset];
    }*/

    // 记忆化搜索
    /*int target, n;
    int[] nums;
    Map<String, Integer> cache;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.n = nums.length;
        this.target = target;
        cache = new HashMap<>();
        return dfs(0, 0);
    }

    private int dfs(int index, int sum) {
        String key = index + "_" + sum;
        if (cache.containsKey(key)) return cache.get(key);
        if (index == n) {
            cache.put(key, sum == target ? 1 : 0);
            return cache.get(key);
        } else {
            int left = dfs(index + 1, sum + nums[index]);
            int right = dfs(index + 1, sum - nums[index]);
            cache.put(key, left + right);
            return cache.get(key);
        }
    }*/

    // 回溯
    /*int ans = 0;

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
    }*/
}
