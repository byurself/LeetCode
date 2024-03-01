package com.lpc.leetcode;

/**
 * 检查数组是否存在有效划分
 *
 * @author byu_rself
 * @date 2024/3/1 9:40
 */
public class P2369 {

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; ++i) {
            boolean a = i - 2 >= 0 && nums[i - 1] == nums[i - 2];
            boolean b = i - 3 >= 0 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3];
            boolean c = i - 3 >= 0 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1;
            f[i] = (a && f[i - 2]) || ((b || c) && f[i - 3]);
        }
        return f[n];
    }

    /*int[] nums;
    int n;
    Boolean[] f;

    public boolean validPartition(int[] nums) {
        this.nums = nums;
        n = nums.length;
        f = new Boolean[n];
        return dfs(0);
    }

    private boolean dfs(int i) {
        if (i == n) return true;
        if (f[i] != null) return f[i];
        boolean a = i + 1 < n && nums[i] == nums[i + 1];
        boolean b = i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2];
        boolean c = i + 2 < n && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1;
        return f[i] = ((a && dfs(i + 2)) || ((b || c) && dfs(i + 3)));
    }*/
}
