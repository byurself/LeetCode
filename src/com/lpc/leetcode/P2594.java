package com.lpc.leetcode;

/**
 * 修车的最少时间
 *
 * @author byu_rself
 * @date 2023/9/7 15:19
 */
public class P2594 {

    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = (long) ranks[0] * cars * cars;
        while (left < right) {
            long mid = left + right >> 1;
            long cnt = 0;
            for (int r : ranks) {
                cnt += Math.sqrt(mid / r);
            }
            if (cnt >= cars) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
