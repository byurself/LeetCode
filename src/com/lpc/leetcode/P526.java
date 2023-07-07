package com.lpc.leetcode;

/**
 * 优美的排列
 *
 * @author byu_rself
 * @date 2023/7/7 9:25
 */
public class P526 {

    public int countArrangement(int n) {
        int mask = 1 << n;
        int[] dp = new int[mask];
        dp[0] = 1;
        for (int visited = 0; visited < mask; ++visited) {
            int i = Integer.bitCount(visited);
            for (int x = 1; x <= n; ++x) {
                if (((1 << (x - 1)) & visited) != 0 && (x % i == 0 || i % x == 0)) {
                    // i - 1 位置没有放入x
                    dp[visited] += dp[visited & (~(1 << (x - 1)))];
                }
            }
        }
        return dp[mask - 1];
    }

    /*public int countArrangement(int n) {
        int mask = 1 << n;
        int[][] dp = new int[n + 1][mask];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int visited = 0; visited < mask; ++visited) {
                if (Integer.bitCount(visited) == i) {
                    for (int x = 1; x <= n; ++x) {
                        if (((1 << (x - 1)) & visited) != 0 && (x % i == 0 || i % x == 0)) {
                            // i - 1位置没有放入x
                            // 1 << (x - 1) 表示第 x 位是1，取反就是这位是0，其他都是1
                            // 再与 visited 与运算表示打掉 visited 这位的 1
                            dp[i][visited] += dp[i - 1][visited & (~(1 << (x - 1)))];
                        }
                    }
                }
            }
        }
        return dp[n][mask - 1];
    }*/

    /*int n;
    int[][] cache;

    public int countArrangement(int n) {
        this.n = n;
        cache = new int[n + 1][1 << n];
        return dfs(1, 0);
    }

    private int dfs(int i, int visited) {
        if (i > n) return 1;
        if (cache[i][visited] != 0) return cache[i][visited];
        int ans = 0;
        for (int x = 1; x <= n; ++x) {
            if ((((1 << x - 1) & visited) == 0) && (x % i == 0 || i % x == 0)) {
                ans += dfs(i + 1, (1 << x - 1) | visited);
            }
        }
        return cache[i][visited] = ans;
    }*/
}
