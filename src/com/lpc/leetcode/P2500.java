package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 删除每行中的最大值
 *
 * @author byu_rself
 * @date 2023/7/27 9:28
 */
public class P2500 {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; ++j) {
            int max = -1;
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] > max) max = grid[i][j];
            }
            ans += max;
        }
        return ans;
    }
}
