package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 *
 * @author byu_rself
 * @date 2023/4/24 14:47
 */
public class P797 {

    int[][] graph;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        path.add(0);
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == n - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j : graph[i]) {
            path.add(j);
            dfs(j);
            path.remove(path.size() - 1);
        }
    }
}
