package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 从第一个节点出发到最后一个节点的受限路径数
 *
 * @author byu_rself
 * @date 2023/3/13 12:51
 */
public class P1786 {

    private static final int MOD = (int) 1e9 + 7;

    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int a = e[0], b = e[1], w = e[2];
            Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<>());
            am.put(b, w);
            map.put(a, am);

            Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<>());
            bm.put(a, w);
            map.put(b, bm);
        }

        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int idx = e[0];
            if (st[idx]) continue;
            st[idx] = true;
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int i : mm.keySet()) {
                dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
                q.add(new int[]{i, dist[i]});
            }
        }

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{i + 1, dist[i + 1]};
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], cur = arr[i][1];
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int next : mm.keySet()) {
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
