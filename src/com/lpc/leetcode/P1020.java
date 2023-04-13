package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 飞地的数量
 *
 * @author byu_rself
 * @date 2023/4/13 13:41
 */
public class P1020 {

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] != 1) continue;
                if (visited[nx][ny]) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) ++ans;
            }
        }
        return ans;
    }
}
