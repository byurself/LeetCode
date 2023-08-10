package com.lpc.leetcode;

/**
 * 粉刷房子
 *
 * @author byu_rself
 * @date 2023/8/10 14:20
 */
public class LCR091 {

    public int minCost(int[][] costs) {
        int red = 0, blue = 0, green = 0;
        for (int[] cost : costs) {
            int r = Math.min(blue, green) + cost[0];
            int b = Math.min(red, green) + cost[1];
            int g = Math.min(red, blue) + cost[2];

            red = r;
            blue = b;
            green = g;
        }
        return Math.min(red, Math.min(blue, green));
    }
}
