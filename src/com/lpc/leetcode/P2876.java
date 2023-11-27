package com.lpc.leetcode;

import java.util.*;

/**
 * 有向图访问计数
 *
 * @author byu_rself
 * @date 2023/11/27 10:13
 */
public class P2876 {

    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] g = new int[n];
        for (int i = 0; i < n; ++i) {
            g[i] = edges.get(i);
        }
        List<Integer>[] rg = new ArrayList[n]; // 反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        int[] in = new int[n];
        for (int x = 0; x < n; ++x) {
            int y = g[x];
            rg[y].add(x);
            ++in[y];
        }

        // 拓扑排序，剪掉 g 上的所有树枝
        // 拓扑排序后，in 值为 1 的点必定在基环上，为 0 的点必定在树枝上
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = g[x];
            if (--in[y] == 0) {
                q.add(y);
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (in[i] <= 0) continue;
            List<Integer> ring = new ArrayList<>();
            for (int x = i; ; x = g[x]) {
                in[x] = -1; // 将基环上的点的入度标记为 -1，避免重复访问
                ring.add(x); // 收集在基环上的点
                if (g[x] == i) break;
            }
            for (int r : ring) {
                rdfs(r, ring.size(), rg, in, ans);
            }
        }
        return ans;
    }

    private void rdfs(int x, int depth, List<Integer>[] rg, int[] in, int[] ans) {
        ans[x] = depth;
        for (int y : rg[x]) {
            if (in[y] == 0) {
                rdfs(y, depth + 1, rg, in, ans);
            }
        }
    }
}
