package com.lpc.leetcode;

/**
 * 保持城市天际线
 *
 * @author byu_rself
 * @date 2023/2/10 16:46
 */
public class P807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int[] maxRow = new int[n], maxCol = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
