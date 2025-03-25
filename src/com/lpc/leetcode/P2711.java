package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 对角线上不同值的数量差
 *
 * @author byu_rself
 * @date 2025/3/25 15:47
 */
public class P2711 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                set.clear();
                for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
                    set.add(grid[x][y]);
                }
                int topLeft = set.size();

                set.clear();
                for (int x = i + 1, y = j + 1; x < m && y < n; ++x, ++y) {
                    set.add(grid[x][y]);
                }
                int bottomRight = set.size();
                ans[i][j] = Math.abs(topLeft - bottomRight);
            }
        }
        return ans;
    }
}
