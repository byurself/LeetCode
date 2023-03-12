package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author byu_rself
 * @date 2023/3/12 14:28
 */
public class P78 {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }
        dfs(nums, i + 1); // 不选

        path.add(nums[i]); // 选
        dfs(nums, i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }
}
