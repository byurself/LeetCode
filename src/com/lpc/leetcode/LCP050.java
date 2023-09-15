package com.lpc.leetcode;

/**
 * 宝石补给
 *
 * @author byu_rself
 * @date 2023/9/15 9:18
 */
public class LCP050 {

    public int giveGem(int[] gem, int[][] operations) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int[] op : operations) {
            int x = op[0], y = op[1], val = gem[x] >> 1;
            gem[y] += val;
            gem[x] -= val;
        }
        for (int x : gem) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        return max - min;
    }
}
