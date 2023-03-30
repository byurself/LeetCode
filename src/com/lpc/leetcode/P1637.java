package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 两点之间不包含任何点的最宽垂直区域
 *
 * @author byu_rself
 * @date 2023/3/30 10:30
 */
public class P1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length, ans = 0;
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n - 1; ++i) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }
}
