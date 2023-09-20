package com.lpc.leetcode;

/**
 * 拿硬币
 *
 * @author byu_rself
 * @date 2023/9/20 9:22
 */
public class LCP006 {

    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) >> 1;
        }
        return ans;
    }
}
