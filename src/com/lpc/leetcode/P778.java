package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 水位上升的泳池中游泳
 *
 * @author byu_rself
 * @date 2023/3/17 13:53
 */
public class P778 {

    int[] p;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private boolean query(int a, int b) {
        return find(a) == find(b);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        p = new int[n * n];
        for (int i = 0; i < n * n; ++i) {
            p[i] = i;
        }
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = i * n + j;
                if (i + 1 < n) {
                    int a = index, b = (i + 1) * n + j;
                    int w = Math.max(grid[i][j], grid[i + 1][j]);
                    edges.add(new int[]{a, b, w});
                }
                if (j + 1 < n) {
                    int a = index, b = i * n + j + 1;
                    int w = Math.max(grid[i][j], grid[i][j + 1]);
                    edges.add(new int[]{a, b, w});
                }
            }
        }
        edges.sort((a, b) -> a[2] - b[2]);
        int start = 0, end = n * n - 1;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if (query(start, end)) return w;
        }
        return 0;
    }
}
