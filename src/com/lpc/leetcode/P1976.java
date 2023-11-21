package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 到达目的地的方案数
 *
 * @author byu_rself
 * @date 2023/3/14 13:42
 */
public class P1976 {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 0x3f3f3f3f;
    int n;
    long[] dist;
    int[][] g;
    int[] in;
    boolean[] visited;

    public int countPaths(int n, int[][] roads) {
        this.n = n;
        g = new int[n][n];
        dist = new long[n];
        in = new int[n];
        visited = new boolean[n];
        for (int[] e : g) Arrays.fill(e, 0x3f3f3f3f);
        for (int[] road : roads) {
            int a = road[0], b = road[1], w = road[2];
            g[a][b] = g[b][a] = w;
        }
        dijkstra();
        for (int[] road : roads) {
            int a = road[0], b = road[1], w = road[2];
            g[a][b] = g[b][a] = 0;
            if (dist[a] + w == dist[b]) {
                g[a][b] = w;
                ++in[b];
            } else if (dist[b] + w == dist[a]) {
                g[b][a] = w;
                ++in[a];
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) queue.offer(i);
        }
        int[] f = new int[n];
        f[0] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < n; ++i) {
                if (g[x][i] == 0) continue;
                f[i] += f[x];
                f[i] %= MOD;
                if (--in[i] == 0) queue.offer(i);
            }
        }
        return f[n - 1];
    }

    private void dijkstra() {
        Arrays.fill(dist, INF);
        dist[0] = 0L;
        for (int i = 0; i < n; ++i) {
            int k = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (k == -1 || dist[j] < dist[k])){
                    k = j;
                }
            }
            visited[k] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[k] + g[k][j]);
            }
        }
    }
}
