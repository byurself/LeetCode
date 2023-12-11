package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小体力消耗路径
 *
 * @author byu_rself
 * @date 2023/3/16 16:25
 */
public class P1631 {

    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        UnionFind p = new UnionFind(m * n);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int diff = Math.abs(heights[i][j] - heights[x][y]);
                    edges.add(new int[]{i * n + j, x * n + y, diff});
                }
            }
        }
        edges.sort((a, b) -> a[2] - b[2]);
        for (int[] e : edges) {
            p.union(e[0], e[1]);
            if (p.connected(0, m * n - 1)) return e[2];
        }
        return 0;
    }

    private static class UnionFind {
        int[] p;
        int[] size;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        public boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = p[pb];
                size[pb] += size[pa];
            }
            return true;
        }

        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    /*int[] p;

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private boolean query(int a, int b) {
        return p[find(a)] == p[find(b)];
    }

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length, column = heights[0].length;
        p = new int[row * column];

        for (int i = 0; i < row * column; ++i) p[i] = i;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                int index = i * column + j;
                if (i + 1 < row) {
                    int a = index, b = (i + 1) * column + j;
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    edges.add(new int[]{a, b, w});
                }
                if (j + 1 < column) {
                    int a = index, b = i * column + j + 1;
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    edges.add(new int[]{a, b, w});
                }
            }
        }
        edges.sort((a, b) -> a[2] - b[2]); // 根据权值升序
        int start = 0, end = row * column - 1;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if (query(start, end)) return w;
        }
        return 0;
    }*/
}
