package com.lpc.leetcode;

import java.util.*;

/**
 * 从第一个节点出发到最后一个节点的受限路径数
 *
 * @author byu_rself
 * @date 2023/3/13 12:51
 */
public class P1786 {

    private static final int MOD = (int) 1e9 + 7;

    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : edges) {
            int a = e[0], b = e[1], w = e[2];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[]{b, w});
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(new int[]{a, w});
        }

        // 堆优化 Dijkstra
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        // [点编号, 点距离] 按照距离从小到大
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            if (visited[idx]) continue;
            visited[idx] = true;
            List<int[]> list = map.get(idx);
            if (list == null) continue;
            for (int[] arr : list) {
                int i = arr[0];
                dist[i] = Math.min(dist[i], dist[idx] + arr[1]);
                q.offer(new int[]{i, dist[i]});
            }
        }

        int[][] arr = new int[n][2];
        // [点编号, 点距离] 按照距离从小到大
        for (int i = 0; i < n; ++i) arr[i] = new int[]{i + 1, dist[i + 1]};
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = 0; i < n; ++i) {
            int idx = arr[i][0], cur = arr[i][1];
            List<int[]> list = map.get(idx);
            if (list == null) continue;
            for (int[] a : list) {
                int next = a[0];
                if (cur > dist[next]) {
                    f[idx] += f[next];
                    f[idx] %= MOD;
                }
            }
            if (idx == 1) break;
        }
        return f[1];
    }
}
