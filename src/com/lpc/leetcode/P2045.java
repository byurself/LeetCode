package com.lpc.leetcode;

import java.util.*;

/**
 * 到达目的地的第二短时间
 *
 * @author byu_rself
 * @date 2023/8/30 10:02
 */
public class P2045 {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        // path[i][0] 表示从 1 到 i 的最短路长度，path[i][1] 表示从 1 到 i 的严格次短路长度
        int[][] path = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        path[1][0] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        while (path[n][1] == Integer.MAX_VALUE) {
            int[] arr = queue.poll();
            int cur = arr[0], len = arr[1];
            for (int next : g[cur]) {
                if (len + 1 < path[next][0]) {
                    path[next][0] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                } else if (len + 1 > path[next][0] && len + 1 < path[next][1]) {
                    path[next][1] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < path[n][1]; ++i) {
            if (ans % (2 * change) >= change) {
                ans = ans + (2 * change - ans % (2 * change));
            }
            ans += time;
        }
        return ans;
    }
}
