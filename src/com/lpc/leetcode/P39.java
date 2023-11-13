package com.lpc.leetcode;

import java.util.*;

/**
 * 组合总和
 *
 * @author byu_rself
 * @date 2022/10/19 12:18
 */
public class P39 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        dfs(0, target);
        return ans;
    }

    private void dfs(int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 剪枝一：从 start 开始遍历，避免产生重复解
        for (int i = start; i < candidates.length; ++i) {
            // 剪枝二：若当前子集和已超过 target，则直接结束循环(因为数组已排序，后面的元素更大，一定会超过 target)
            if (target - candidates[i] < 0) break;
            path.add(candidates[i]);
            dfs(i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    // 回溯
    /*List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(0, target);
        return ans;
    }

    private void dfs(int i, int target) {
        if (i == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(i + 1, target);
        // 选
        if (target - candidates[i] >= 0) {
            path.add(candidates[i]);
            dfs(i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }*/
}
