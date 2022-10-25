package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最短的桥
 *
 * @author byu_rself
 * @date 2022/10/25 21:24
 */
public class P934 {

    int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 上、下、右、左四个方向
    Deque<int[]> edges; // 用户存储边缘格子

    public int shortestBridge(int[][] grid) {
        int result = 0;
        edges = new ArrayDeque<>();
        boolean flag = false;
        this.grid = grid;
        for (int i = 0; !flag && i < grid.length; i++) {
            for (int j = 0; !flag && j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    markIsland(i, j);
                }
            }
        }

        while (!edges.isEmpty()) {
            result++; // 扩展层数
            int num = edges.size();
            for (int i = 0; i < num; i++) {
                int[] edge = edges.removeFirst();
                for (int[] c : coordinates) {
                    int nex = edge[0] + c[0], ney = edge[1] + c[1];
                    if (isLegal(nex, ney) && grid[nex][ney] == 0) {
                        edges.addLast(new int[]{nex, ney});
                        grid[nex][ney] = 2;
                    } else if (isLegal(nex, ney) && grid[nex][ney] == 1) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public void markIsland(int i, int j) {
        if (!isLegal(i, j) || grid[i][j] == 2) return;
        if (grid[i][j] == 0) {
            grid[i][j] = 2;
            edges.addLast(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        for (int[] c : coordinates) markIsland(i + c[0], j + c[1]);
    }

    public boolean isLegal(int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
