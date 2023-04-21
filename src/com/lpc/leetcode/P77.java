package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @author byu_rself
 * @date 2023/4/21 0:02
 */
public class P77 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }

    private void dfs(int i) {
        int d = k - path.size();
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        if (i > d) dfs(i - 1);

        // 选
        path.add(i);
        dfs(i - 1);
        path.remove(path.size() - 1);
    }

/*    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }

    private void dfs(int i) {
        int d = k - path.size(); // 还要选d个数
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; --j) {
            path.add(j);
            dfs(j - 1);
            path.remove(path.size() - 1);
        }
    }*/
}
