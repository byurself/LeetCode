package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最大人工岛
 *
 * @author byu_rself
 * @date 2022/9/18 3:36
 */
public class P827 {

    private int[] p;
    private int[] size;
    private final int[] dirs = new int[]{-1, 0, 1, 0, -1};
    private int n;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (size[px] > size[py]) {
            size[px] += size[py];
            p[py] = p[px];
        } else {
            size[py] += size[px];
            p[px] = p[py];
        }
    }

    public int largestIsland(int[][] grid) {
        n = grid.length;
        p = new int[n * n];
        size = new int[n * n];
        for (int i = 0; i < n * n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; ++k) {
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                        union(getIndex(i, j), getIndex(x, y));
                    }
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) ans = Math.max(ans, size[find(getIndex(i, j))]);
                else {
                    int t = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dirs[k], y = j + dirs[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            int root = find(getIndex(x, y));
                            if (!set.contains(root)) {
                                set.add(root);
                                t += size[root];
                            }
                        }
                    }
                    ans = Math.max(ans, t);
                }
            }
        }
        return ans;
    }

    private int getIndex(int i, int j) {
        return i * n + j;
    }
}
