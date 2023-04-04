package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 边界着色
 *
 * @author byu_rself
 * @date 2023/4/4 13:19
 */
public class P1034 {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], cnt = 0;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue; // 越界
                if (grid[x][y] != grid[nx][ny]) continue; // 不是同一个连通分量
                else ++cnt;
                if (ans[x][y] == 0) queue.offer(new int[]{nx, ny}); // 若[x, y]未被处理过，则加入队列
            }
            ans[x][y] = cnt == 4 ? grid[x][y] : color; // 若不是边界，则为原grid[x][y]值，否则涂成color
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ans[i][j] == 0) ans[i][j] = grid[i][j];
            }
        }
        return ans;
    }
}
