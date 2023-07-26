package com.lpc.leetcode;

/**
 * 球会落何处
 *
 * @author byu_rself
 * @date 2023/7/26 9:37
 */
public class P1706 {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; ++j) {
            int col = j;
            for (int[] row : grid) {
                int point = row[col];
                col += point; // 移动
                if (col < 0 || col == n || row[col] != point) {
                    col = -1;
                    break;
                }
            }
            ans[j] = col;
        }
        return ans;
    }
}
