package com.lpc.leetcode;

/**
 * 购买两块巧克力
 *
 * @author byu_rself
 * @date 2023/12/29 9:26
 */
public class P2706 {

    public int buyChoco(int[] prices, int money) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int x : prices) {
            if (x < a) {
                b = a;
                a = x;
            } else if (x < b) {
                b = x;
            }
        }
        int cost = a + b;
        return money < cost ? money : money - cost;
    }
}
