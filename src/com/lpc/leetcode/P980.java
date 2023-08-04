package com.lpc.leetcode;

/**
 * 不同路径III
 *
 * @author byu_rself
 * @date 2023/8/4 9:17
 */
public class P980 {

    int[][] grid;
    int m, n, cnt;
    boolean[][] visited;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int x = 0, y = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) ++cnt;
                else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        visited[x][y] = true;
        return dfs(x, y, 0);
    }

    /**
     * 从 (x, y) 出发，且当前已经走过的单元格数量为 k 的路径数
     */
    private int dfs(int x, int y, int k) {
        if (grid[x][y] == 2) return k == cnt + 1 ? 1 : 0;
        int ans = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] == -1) continue;
            visited[nx][ny] = true;
            ans += dfs(nx, ny, k + 1);
            visited[nx][ny] = false;
        }
        return ans;
    }
}
