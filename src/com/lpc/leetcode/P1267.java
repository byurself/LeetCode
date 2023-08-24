package com.lpc.leetcode;

/**
 * 统计参与通信的服务器
 *
 * @author byu_rself
 * @date 2023/8/24 10:57
 */
public class P1267 {

    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] cntRow = new int[m], cntCol = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++cntRow[i];
                    ++cntCol[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && (cntRow[i] > 1 || cntCol[j] > 1)) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
