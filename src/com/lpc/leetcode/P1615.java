package com.lpc.leetcode;

/**
 * 最大网络秩
 *
 * @author byu_rself
 * @date 2023/3/15 14:10
 */
public class P1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] cnt = new int[n];
        int[][] g = new int[n][n];
        int ans = 0;
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            g[a][b] = 1;
            g[b][a] = 1;
            ++cnt[a];
            ++cnt[b];
        }
        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                ans = Math.max(ans, cnt[a] + cnt[b] - g[a][b]);
            }
        }
        return ans;
    }
}
