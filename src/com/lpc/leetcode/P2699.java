package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 修改图中的边权
 *
 * @author byu_rself
 * @date 2023/6/9 9:11
 */
public class P2699 {

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < edges.length; ++i) {
            // 建图，额外记录边的编号
            int x = edges[i][0], y = edges[i][1];
            g[x].add(new int[]{y, i});
            g[y].add(new int[]{x, i});
        }
        int[][] distance = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i != source) {
                distance[i][0] = distance[i][1] = Integer.MAX_VALUE;
            }
        }

        dijkstra(g, edges, destination, distance, 0, 0);
        int delta = target - distance[destination][0];
        // -1 全改为 1 时，最短路比 target 还大
        if (delta < 0) return new int[][]{};

        dijkstra(g, edges, destination, distance, delta, 1);
        // 最短路无法再变大，无法达到 target
        if (distance[destination][1] < target) return new int[][]{};

        for (int[] e : edges) {
            // 剩余没修改的边全部改成 1
            if (e[2] == -1) e[2] = 1;
        }
        return edges;
    }

    /**
     * 朴素 Dijkstra 算法
     *
     * @param g           图
     * @param edges       边
     * @param destination 终点
     * @param distance    距离
     * @param delta       差值
     * @param k           第几次
     */
    private void dijkstra(List<int[]> g[], int[][] edges, int destination, int[][] distance, int delta, int k) {
        int n = g.length;
        boolean[] visited = new boolean[n];
        for (; ; ) {
            // 找到当前最短路，去更新它的邻居的最短路
            // 根据数学归纳法，dis[x][k] 一定是最短路长度
            int x = -1;
            for (int i = 0; i < n; ++i) {
                if (!visited[i] && (x < 0 || distance[i][k] < distance[x][k])) x = i;
            }
            // 起点 source 到终点 destination 的最短路已确定
            if (x == destination) return;
            visited[x] = true; // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
            for (int[] e : g[x]) {
                int y = e[0], eid = e[1];
                int wt = edges[eid][2];
                if (wt == -1) wt = 1; // -1 改成 1
                if (k == 1 && edges[eid][2] == -1) {
                    // 第二次 Dijkstra，改成 w
                    int w = delta + distance[y][0] - distance[x][1];
                    if (w > wt) edges[eid][2] = wt = w; // 直接在 edges 上修改
                }
                // 更新最短路
                distance[y][k] = Math.min(distance[y][k], distance[x][k] + wt);
            }
        }
    }
}
