package com.lpc.leetcode;

import java.util.Arrays;

/**
 * @author byu_rself
 * @date 2023/3/12 17:35
 */
public class P787 {

    private static final int INF = 0x3f3f3f3f;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans = INF;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) Arrays.fill(f[i], INF);
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}
