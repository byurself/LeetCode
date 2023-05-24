package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * T秒后青蛙的位置
 *
 * @author byu_rself
 * @date 2023/5/24 9:36
 */
public class P1377 {

    @Test
    public void solution() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        System.out.println(frogPosition(7, edges, 2, 4));
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            g[u].add(v);
            g[v].add(u);
        }
        // 给1节点添加一个0号节点，避免特判 n = 1 的情况
        g[1].add(0);
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 1});
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        visited[1] = true;
        while (!queue.isEmpty() && t >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                var cur = queue.poll();
                int u = cur[0], p = cur[1];
                int cnt = g[u].size() - 1;
                if (u == target) {
                    // 如果到达目标顶点，需要判断
                    // 1.是否在t秒到达目标顶点
                    // 2.小于t秒时到达目标顶点，但无法再跳跃至其他顶点
                    return cnt * t == 0 ? 1.0 / p : 0;
                }
                for (int v : g[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(new int[]{v, p * cnt});
                    }
                }
            }
            --t;
        }
        return 0;
    }

    public double frogPosition1(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            g[u].add(v);
            g[v].add(u);
        }
        Deque<Pair<Integer, Double>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(1, 1.0));
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!queue.isEmpty() && t >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                var cur = queue.poll();
                int u = cur.key;
                double p = cur.value;
                int cnt = g[u].size() - (u == 1 ? 0 : 1);
                if (u == target) {
                    // 如果到达目标顶点，需要判断
                    // 1.是否在t秒到达目标顶点
                    // 2.小于t秒时到达目标顶点，但无法再跳跃至其他顶点
                    return cnt * t == 0 ? p : 0;
                }
                for (int v : g[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(new Pair<>(v, p / cnt));
                    }
                }
            }
            --t;
        }
        return 0;
    }

    private static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
