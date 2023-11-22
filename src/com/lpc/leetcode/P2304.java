package com.lpc.leetcode;

/**
 * 网格中的最小路径代价
 *
 * @author byu_rself
 * @date 2023/11/22 10:57
 */
public class P2304 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                int ans = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    ans = Math.min(ans, grid[i + 1][k] + moveCost[grid[i][j]][k]);
                }
                grid[i][j] += ans;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : grid[0]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }

/*    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[m - 1] = grid[m - 1];
        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i + 1][k] + moveCost[grid[i][j]][k]);
                }
                f[i][j] += grid[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : f[0]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }*/

    // 记忆化搜索
    /*int m, n;
    int[][] grid;
    int[][] moveCost;
    int[][] cache;

    public int minPathCost(int[][] grid, int[][] moveCost) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        this.moveCost = moveCost;
        cache = new int[m][n];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; ++j) {
            ans = Math.min(ans, dfs(0, j));
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (i == m - 1) return grid[i][j];
        if (cache[i][j] != 0) return cache[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; ++k) {
            ans = Math.min(ans, dfs(i + 1, k) + moveCost[grid[i][j]][k]);
        }
        return cache[i][j] = ans + grid[i][j];
    }*/
}
