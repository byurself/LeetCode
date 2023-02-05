package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 穿过迷宫的最少移动次数
 *
 * @author byu_rself
 * @date 2023/2/5 11:44
 */
public class P1210 {

    private static final int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] vis = new boolean[n][n][2];
        List<int[]> list = new ArrayList<>();
        vis[0][0][0] = true;
        list.add(new int[]{0, 0, 0}); // 初始位置
        for (int step = 1; !list.isEmpty(); ++step) {
            List<int[]> temp = list;
            list = new ArrayList<>();
            for (int[] t : temp) {
                for (int[] d : DIRS) {
                    int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
                    int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                    if (x2 < n && y2 < n && !vis[x][y][s] && grid[x][y] == 0 && grid[x2][y2] == 0 && (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2) return step; // 此时蛇头一定在 (n-1,n-1)
                        vis[x][y][s] = true;
                        list.add(new int[]{x, y, s});
                    }
                }
            }
        }
        return -1;
    }
}
