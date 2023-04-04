package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 网络空闲的时刻
 *
 * @author byu_rself
 * @date 2023/4/4 13:48
 */
public class P2039 {

    private static int N = 100010, M = 2 * N, INF = 0x3f3f3f3f;
    private static int[] he = new int[N], e = new int[M], ne = new int[M];
    private static int[] dist = new int[N];
    int index;

    private void add(int a, int b) {
        e[index] = b;
        ne[index] = he[a];
        he[a] = index++;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Arrays.fill(he, -1);
        Arrays.fill(dist, INF);
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        dist[0] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = he[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] != INF) continue;
                dist[j] = dist[cur] + 1;
                queue.offer(j);
            }
        }
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int d = dist[i] * 2, t = patience[i];
            int cur = d <= t ? d : (d - 1) / t * t + d;
            if (cur > ans) ans = cur;
        }
        return ans + 1;
    }
}
