package com.lpc.leetcode;

import java.util.*;

/**
 * 组合总和
 *
 * @author byu_rself
 * @date 2022/10/19 12:18
 */
public class P39 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> list, int index) {
        if (index == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(candidates, target, list, index + 1);
        if (target - candidates[index] >= 0) {
            list.add(candidates[index]);
            dfs(candidates, target - candidates[index], list, index);
            list.remove(list.size() - 1);
        }
    }
}
