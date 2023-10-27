package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 切割后面积最大的蛋糕
 *
 * @author byu_rself
 * @date 2023/10/27 14:35
 */
public class P1465 {

    private static final int MOD = (int) 1e9 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length, n = verticalCuts.length;
        int x = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        int y = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for (int i = 1; i < m; ++i) {
            x = Math.max(x, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < n; ++i) {
            y = Math.max(y, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) (((long) x * y) % MOD);
    }
}
