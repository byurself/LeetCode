package com.lpc.leetcode;

/**
 * 一个图中连通三元组的最小度数
 *
 * @author byu_rself
 * @date 2023/8/31 9:21
 */
public class P1761 {

    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
        int[] deg = new int[n];
        for (int[] e : edges) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a][b] = true;
            g[b][a] = true;
            ++deg[a];
            ++deg[b];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (g[i][j]) {
                    for (int k = j + 1; k < n; ++k) {
                        if (g[i][k] && g[j][k]) {
                            ans = Math.min(ans, deg[i] + deg[j] + deg[k] - 6);
                        }
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
