package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子
 *
 * @author byu_rself
 * @date 2024/5/13 9:26
 */
public class P994 {

    static final int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0, cnt = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++cnt;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && cnt > 0) {
            for (int size = queue.size(); size > 0; --size) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        --cnt;
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            ++ans;
        }
        return cnt > 0 ? -1 : ans;
    }
}
