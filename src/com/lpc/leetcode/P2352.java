package com.lpc.leetcode;

/**
 * 相等行列对
 *
 * @author byu_rself
 * @date 2023/6/6 8:53
 */
public class P2352 {

    public int equalPairs(int[][] grid) {
        int n = grid.length, ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isEqual(i, j, n, grid)) ++ans;
            }
        }
        return ans;
    }

    private boolean isEqual(int row, int col, int n, int[][] grid) {
        for (int i = 0; i < n; ++i) {
            if (grid[row][i] != grid[i][col]) return false;
        }
        return true;
    }
}
