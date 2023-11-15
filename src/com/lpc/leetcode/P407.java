package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 接雨水II
 *
 * @author byu_rself
 * @date 2023/11/15 10:14
 */
public class P407 {

    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int trapRainWater(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        // 存放三元组 [x,y,h]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // 先把最外一圈放进去
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i, j, heights[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (cur[2] > heights[nx][ny]) {
                        ans += cur[2] - heights[nx][ny];
                    }
                    pq.offer(new int[]{nx, ny, Math.max(heights[nx][ny], cur[2])});
                    visited[nx][ny] = true;
                }
            }
        }
        return ans;
    }
}
