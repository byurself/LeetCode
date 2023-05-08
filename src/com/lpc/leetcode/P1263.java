package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 推箱子
 *
 * @author byu_rself
 * @date 2023/5/8 16:54
 */
public class P1263 {

    int m, n;
    char[][] grid;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minPushBox(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int si = 0, sj = 0, bi = 0, bj = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'S') {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 'B') {
                    bi = i;
                    bj = j;
                }
            }
        }
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m * n][m * n];
        queue.offer(new int[]{getIndex(si, sj), getIndex(bi, bj), 0});
        visited[getIndex(si, sj)][getIndex(bi, bj)] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int step = cur[2];
            bi = cur[1] / n;
            bj = cur[1] % n;
            if (grid[bi][bj] == 'T') return step;
            si = cur[0] / n;
            sj = cur[0] % n;
            for (int[] dir : dirs) {
                int sx = si + dir[0], sy = sj + dir[1];
                if (sx < 0 || sx >= m || sy < 0 || sy >= n || grid[sx][sy] == '#') continue;
                if (sx == bi && sy == bj) {
                    int bx = bi + dir[0], by = bj + dir[1];
                    if (bx < 0 || bx >= m || by < 0 || by >= n || grid[bx][by] == '#') continue;
                    if (visited[getIndex(sx, sy)][getIndex(bx, by)]) continue;
                    visited[getIndex(sx, sy)][getIndex(bx, by)] = true;
                    queue.offer(new int[]{getIndex(sx, sy), getIndex(bx, by), step + 1});
                } else if (!visited[getIndex(sx, sy)][getIndex(bi, bj)]) {
                    visited[getIndex(sx, sy)][getIndex(bi, bj)] = true;
                    queue.offerFirst(new int[]{getIndex(sx, sy), getIndex(bi, bj), step});
                }
            }
        }
        return -1;
    }

    private int getIndex(int i, int j) {
        return i * n + j;
    }
}
