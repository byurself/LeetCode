package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 细分图中的可到达节点
 *
 * @author byu_rself
 * @date 2023/11/15 10:35
 */
public class P882 {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1], cnt = e[2] + 1;
            g[a].add(new int[]{b, cnt});
            g[b].add(new int[]{a, cnt});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, 0x3f3f3f3f);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0});
        dist[0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int d = cur[0], u = cur[1];
            for (int[] next : g[u]) {
                int v = next[0], cnt = next[1];
                if (d + cnt < dist[v]) {
                    dist[v] = d + cnt;
                    q.offer(new int[]{dist[v], v});
                }
            }
        }
        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) {
                ++ans;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int a = Math.min(cnt, Math.max(0, maxMoves - dist[u]));
            int b = Math.min(cnt, Math.max(0, maxMoves - dist[v]));
            ans += Math.min(cnt, a + b);
        }
        return ans;
    }
}
