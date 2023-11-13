package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和II
 *
 * @author byu_rself
 * @date 2023/11/13 10:09
 */
public class P40 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            // 剪枝三：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
