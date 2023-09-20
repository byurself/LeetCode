package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 树中距离之和
 *
 * @author byu_rself
 * @date 2023/7/16 16:00
 */
public class P834 {

    List<Integer>[] g;
    int[] ans, size;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        ans = new int[n];
        size = new int[n];
        dfs(0, -1, 0);
        reroot(0, -1);
        return ans;
    }

    private void reroot(int x, int pa) {
        for (int y : g[x]) {
            if (y != pa) {
                ans[y] = ans[x] + n - 2 * size[y];
                reroot(y, x);
            }
        }
    }

    /**
     * @param x     当前遍历到的节点
     * @param pa    父节点
     * @param depth 0~当前节点的深度
     */
    private void dfs(int x, int pa, int depth) {
        ans[0] += depth;
        size[x] = 1;
        for (int y : g[x]) {
            if (y != pa) {
                dfs(y, x, depth + 1);
                size[x] += size[y];
            }
        }
    }

    /*int n;
    List<Integer>[] g;
    int[] ans, size;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        ans = new int[n];
        size = new int[n];
        dfs(0, -1, 0);
        reroot(0, -1);
        return ans;
    }

    *//**
     * @param x     当前遍历到的节点
     * @param pa    父节点
     * @param depth 0~当前节点的深度
     *//*
    private void dfs(int x, int pa, int depth) {
        ans[0] += depth;
        size[x] = 1;
        for (int y : g[x]) {
            if (y != pa) {
                dfs(y, x, depth + 1);
                size[x] += size[y];
            }
        }
    }

    private void reroot(int x, int pa) {
        for (int y : g[x]) {
            if (y != pa) {
                ans[y] = ans[x] + n - 2 * size[y];
                reroot(y, x);
            }
        }
    }*/
}
