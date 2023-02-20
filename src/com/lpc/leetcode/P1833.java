package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 雪糕的最大数量
 *
 * @author byu_rself
 * @date 2023/2/20 10:53
 */
public class P1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                coins -= cost;
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
