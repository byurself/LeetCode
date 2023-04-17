package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 访问所有节点的最短路径
 *
 * @author byu_rself
 * @date 2023/4/17 15:46
 */
public class P847 {

    private static final int INF = 0x3f3f3f3f;

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; ++i) Arrays.fill(dist[i], INF);
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            dist[1 << i][i] = 0;
            queue.offer(new int[]{1 << i, i});
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int state = cur[0], x = cur[1], step = dist[state][x];
            if (state == mask - 1) return step;
            for (int i : graph[x]) {
                if (dist[state | (1 << i)][i] == INF) {
                    dist[state | (1 << i)][i] = step + 1;
                    queue.offer(new int[]{state | (1 << i), i});
                }
            }
        }
        return -1;
    }
}
