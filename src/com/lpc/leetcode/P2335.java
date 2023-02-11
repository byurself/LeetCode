package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 装满杯子需要的最短总时长
 *
 * @author byu_rself
 * @date 2023/2/11 14:00
 */
public class P2335 {

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) return amount[2];
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    public int fillCups1(int[] amount) {
        int ans = 0;
        while (amount[0] + amount[1] + amount[2] > 0) {
            ans++;
            Arrays.sort(amount);
            amount[2]--;
            amount[1] = Math.max(amount[1] - 1, 0);
        }
        return ans;
    }
}
