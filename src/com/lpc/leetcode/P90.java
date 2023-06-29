package com.lpc.leetcode;

import java.util.*;

/**
 * 子集II
 *
 * @author byu_rself
 * @date 2023/6/29 9:53
 */
public class P90 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(false, 0);
        return new ArrayList<>(ans);
    }

    /**
     * @param flag 是否选择前一个数
     * @param i    当前下标
     */
    private void dfs(boolean flag, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(false, i + 1);

        // 选
        if (!flag && i > 0 && nums[i - 1] == nums[i]) return;
        path.add(nums[i]);
        dfs(true, i + 1);
        path.remove(path.size() - 1);
    }

/*    List<Integer> path = new ArrayList<>();
    Set<List<Integer>> ans = new HashSet<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return new ArrayList<>(ans);
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(i + 1); // 不选

        path.add(nums[i]); // 选
        dfs(i + 1);
        path.remove(path.size() - 1);
    }*/
}
