package com.lpc.leetcode;

/**
 * 检查骑士巡视方案
 *
 * @author byu_rself
 * @date 2023/9/13 9:34
 */
public class P2596 {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int n = grid.length;
        int[][] pos = new int[n * n][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                pos[grid[i][j]] = new int[]{i, j};
            }
        }
        for (int i = 1; i < n * n; ++i) {
            int[] p1 = pos[i - 1], p2 = pos[i];
            int dx = Math.abs(p1[0] - p2[0]);
            int dy = Math.abs(p1[1] - p2[1]);
            boolean flag = (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
            if (!flag) return false;
        }
        return true;
    }
}
