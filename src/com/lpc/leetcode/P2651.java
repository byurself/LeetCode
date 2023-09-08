package com.lpc.leetcode;

/**
 * 计算列车到站时间
 *
 * @author byu_rself
 * @date 2023/9/8 8:56
 */
public class P2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
