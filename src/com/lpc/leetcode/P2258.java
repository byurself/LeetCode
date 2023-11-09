package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逃离火灾
 *
 * @author byu_rself
 * @date 2023/11/9 9:02
 */
public class P2258 {

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] grid;
    int m, n;

    public int maximumMinutes(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int[][] fire = new int[m][n], people = new int[m][n];
        Deque<int[]> fd = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    fire[i][j] = 1;
                    fd.offer(new int[]{i, j});
                }
            }
        }
        bfs(fd, fire);
        Deque<int[]> pd = new ArrayDeque<>();
        pd.offer(new int[]{0, 0});
        people[0][0] = 1;
        bfs(pd, people);
        int p = people[m - 1][n - 1], f = fire[m - 1][n - 1], ans = f - p;
        if (p == 0) return -1;
        if (f == 0) return (int) 1e9;
        if (p > f) return -1;
        if (people[m - 1][n - 2] != 0 && ans + people[m - 1][n - 2] < fire[m - 1][n - 2]) return ans;
        if (people[m - 2][n - 1] != 0 && ans + people[m - 2][n - 1] < fire[m - 2][n - 1]) return ans;
        return ans - 1;
    }

    private void bfs(Deque<int[]> queue, int[][] time) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] == 2) continue;
                if (time[nx][ny] != 0) continue;
                time[nx][ny] = time[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    // BFS + 二分
    /*static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    boolean flag;
    int[][] grid, fire, people;

    public int maximumMinutes(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        fire = new int[m][n];
        people = new int[m][n];
        if (!check(0)) return -1;
        int left = 0, right = m * n;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid)) left = mid;
            else right = mid - 1;
        }
        return right == m * n ? (int) 1e9 : right;
    }

    private boolean check(int t) {
        flag = false;
        Deque<int[]> fd = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                fire[i][j] = people[i][j] = 0;
                // 着火
                if (grid[i][j] == 1) {
                    fire[i][j] = 1;
                    fd.offer(new int[]{i, j});
                }
            }
        }
        // 先执行t秒的火势蔓延
        while (t-- > 0) {
            update(fd, true, 0);
        }
        if (fire[0][0] != 0) return false;
        Deque<int[]> pd = new ArrayDeque<>();
        people[0][0] = 1;
        pd.offer(new int[]{0, 0});
        while (!pd.isEmpty()) {
            // 先火后人
            update(fd, true, 1);
            update(pd, false, 1);
            if (flag) return true;
        }
        return false;
    }

    private void update(Deque<int[]> queue, boolean isFire, int offset) {
        int size = queue.size();
        while (size-- > 0) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                // 遇到墙
                if (grid[nx][ny] == 2) continue;
                if (isFire) {
                    if (fire[nx][ny] != 0) continue;
                    fire[nx][ny] = fire[x][y] + offset;
                } else {
                    // 火尚未到达或同时到达
                    if (nx == m - 1 && ny == n - 1 && (fire[nx][ny] == 0 || fire[nx][ny] == people[x][y] + offset))
                        flag = true;
                    if (fire[nx][ny] != 0 || people[nx][ny] != 0) continue;
                    people[nx][ny] = people[x][y] + offset;
                }
                queue.offer(new int[]{nx, ny});
            }
        }
    }*/
}
