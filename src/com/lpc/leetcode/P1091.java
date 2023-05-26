package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二进制矩阵中的最短路径
 *
 * @author byu_rself
 * @date 2023/5/26 9:02
 */
public class P1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        grid[0][0] = 1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if (x == n - 1 && y == n - 1) return ans;
                for (int nx = x - 1; nx <= x + 1; ++nx) {
                    for (int ny = y - 1; ny <= y + 1; ++ny) {
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (grid[nx][ny] == 1) continue;
                        grid[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            ++ans;
        }
        return -1;
    }
}
