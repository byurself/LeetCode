package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 网络延迟时间
 *
 * @author byu_rself
 * @date 2023/3/12 17:22
 */
public class P743 {

    private static final int INF = 0x3f3f3f3f;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        for (int[] e : g) {
            Arrays.fill(e, INF);
        }
        for (int[] t : times) {
            int a = t[0] - 1, b = t[1] - 1, w = t[2];
            g[a][b] = w;
        }
        int[] dist = new int[n];
        Arrays.fill(dist ,INF);
        dist[k - 1] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (x == -1 || dist[x] > dist[j])) {
                    x = j;
                }
            }
            visited[x] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[x] + g[x][j]);
            }
        }
        int ans = -1;
        for (int x : dist) {
            ans = Math.max(ans, x);
        }
        return ans == INF ? -1 : ans;
    }

    /*public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) Arrays.fill(g[i], INF);
        for (int[] time : times) {
            int x = time[0] - 1, y = time[1] - 1;
            g[x][y] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!visited[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            visited[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }*/
}
