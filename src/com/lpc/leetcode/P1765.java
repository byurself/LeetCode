package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 地图中的最高点
 *
 * @author byu_rself
 * @date 2023/4/5 18:35
 */
public class P1765 {

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) queue.offer(new int[]{i, j});
                ans[i][j] = grid[i][j] == 1 ? 0 : -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int height = ans[x][y];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (ans[nx][ny] != -1) continue;
                ans[nx][ny] = height + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return ans;
    }
}
