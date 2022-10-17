package com.lpc.leetcode;

/**
 * 零钱兑换
 *
 * @author byu_rself
 * @date 2022/10/17 11:44
 */
public class P322 {
    int[] cache;

    public int coinChange(int[] coins, int amount) {
        cache = new int[amount];
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;

        if (cache[amount - 1] != 0) return cache[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin);
            if (res >= 0 && res < min) min = res + 1;
        }
        cache[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return cache[amount - 1];
    }
}
