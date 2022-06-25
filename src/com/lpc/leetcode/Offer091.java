package com.lpc.leetcode;

/**
 * 粉刷房子
 *
 * @author byu_rself
 * @date 2022/6/25 23:19
 */
public class Offer091 {

    public void solution() {
        int[][] costs = new int[][]{{7, 6, 2}};
        System.out.println(minCost(costs));
    }

    public int minCost(int[][] costs) {
        int red = 0, blue = 0, green = 0;
        for (int[] cost : costs) {
            int r = Math.min(blue, green) + cost[0], b = Math.min(red, green) + cost[1], g = Math.min(red, blue) + cost[2];
            red = r;
            blue = b;
            green = g;
        }
        return Math.min(red, Math.min(blue, green));
    }
}
