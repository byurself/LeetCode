package com.lpc.leetcode;

/**
 * 拼车
 *
 * @author byu_rself
 * @date 2023/9/28 9:45
 */
public class P1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            d[from] += num;
            d[to] -= num;
        }
        int sum = 0;
        for (int x : d) {
            sum += x;
            if (sum > capacity) return false;
        }
        return true;
    }
}
