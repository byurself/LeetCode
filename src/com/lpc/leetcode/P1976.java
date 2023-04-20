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

    private static final int N = 201, MOD = (int) 1e9 + 7;
    private static final long INF = (long) 1e12;
    int n;
    long[] dist = new long[N];
    int[][] g = new int[N][N];
    int[] in = new int[N];
    boolean[] visited = new boolean[N];

    public int countPaths(int n, int[][] roads) {
        this.n = n;
        for (int[] info : roads) {
            int a = info[0], b = info[1], c = info[2];
            g[a][b] = g[b][a] = c;
        }
        dijkstra();
        for (int[] info : roads) {
            int a = info[0], b = info[1], c = info[2];
            g[a][b] = g[b][a] = 0;
            if (dist[a] + c == dist[b]) {
                g[a][b] = c;
                ++in[b];
            } else if (dist[b] + c == dist[a]) {
                g[b][a] = c;
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
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            visited[t] = true;
            for (int j = 0; j < n; ++j) {
                if (g[t][j] == 0) continue;
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
    }
}
