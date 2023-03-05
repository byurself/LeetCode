package com.lpc.leetcode;

/**
 * 经营摩天轮的最大利润
 *
 * @author byu_rself
 * @date 2023/3/5 14:20
 */
public class P1599 {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length, i = 0, ans = -1, max = 0, profit = 0, wait = 0;
        while (wait > 0 || i < n) {
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(wait, 4);
            wait -= up;
            ++i;
            profit += up * boardingCost - runningCost;
            if (profit > max) {
                max = profit;
                ans = i;
            }
        }
        return ans;
    }
}
