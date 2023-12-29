package com.lpc.leetcode;

/**
 * 出界的路径数
 *
 * @author byu_rself
 * @date 2023/12/29 9:52
 */
public class P576 {

    int m, n;
    int[][][] cache;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int MOD = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k <= maxMove; ++k) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 1;
        if (k == 0) return 0;
        if (cache[x][y][k] != -1) return cache[x][y][k];
        int ans = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            ans += dfs(nx, ny, k - 1);
            ans %= MOD;
        }
        return cache[x][y][k] = ans;
    }
}
