package com.lpc.leetcode;

import java.util.*;

/**
 * 每棵子树内缺失的最小基因值
 *
 * @author byu_rself
 * @date 2023/10/31 9:45
 */
public class P2003 {

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length, node = -1;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                node = i; // 出发点
                break;
            }
        }
        if (node == -1) return ans;

        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parents[i]].add(i);
        }
        Set<Integer> visited = new HashSet<>();
        int min = 2; // 缺失的最小基因值
        while (node >= 0) {
            dfs(node, g, visited, nums);
            while (visited.contains(min)) {
                ++min;
            }
            ans[node] = min;
            node = parents[node];
        }
        return ans;
    }

    private void dfs(int x, List<Integer>[] g, Set<Integer> visited, int[] nums) {
        visited.add(nums[x]);
        for (int y : g[x]) {
            if (!visited.contains(nums[y])) {
                dfs(y, g, visited, nums);
            }
        }
    }
}
