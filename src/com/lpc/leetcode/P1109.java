package com.lpc.leetcode;

/**
 * 航班预订统计
 *
 * @author byu_rself
 * @date 2023/9/28 9:54
 */
public class P1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] d = new int[n];
        for (int[] b : bookings) {
            int first = b[0], last = b[1], seat = b[2];
            d[first - 1] += seat;
            if (last < n) {
                d[last] -= seat;
            }
        }
        for (int i = 1; i < n; ++i) {
            d[i] += d[i - 1];
        }
        return d;
    }
}
