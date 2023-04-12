package com.lpc.leetcode;

import java.util.*;

/**
 * 找到最终的安全状态
 *
 * @author byu_rself
 * @date 2023/4/12 20:25
 */
public class P802 {

    int N = (int) 1e4 + 10, M = 4 * N;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    int[] cnt = new int[N];

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                add(j, i);
                ++cnt[i];
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = he[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--cnt[j] == 0) queue.offer(j);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) ans.add(i);
        }
        return ans;
    }
}
