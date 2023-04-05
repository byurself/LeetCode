package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 地图分析
 *
 * @author byu_rself
 * @date 2023/4/5 16:26
 */
public class P1162 {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};



    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int step = Math.max(grid[x][y], 0);
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 越界
                if (grid[nx][ny] != 0) continue; // 已经访问过
                queue.offer(new int[]{nx, ny});
                grid[nx][ny] = step + 1;
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }

    /*    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Deque<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int step = map.get(x * n + y);
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 越界
                if (grid[nx][ny] != 0) continue; // 已经访问过
                queue.offer(new int[]{nx, ny});
                grid[nx][ny] = step + 1;
                map.put(nx * n + ny, step + 1);
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }*/

/*    public int maxDistance(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        return ans;
    }

    private int bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(new int[]{i, j});
        map.put(i * n + j, 0);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int step = map.get(x * n + y);
            if (grid[x][y] == 1) return step;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                int key = nx * n + ny;
                if (map.containsKey(key)) continue;
                queue.offer(new int[]{nx, ny});
                map.put(key, step + 1);
            }
        }
        return -1;
    }*/
}
