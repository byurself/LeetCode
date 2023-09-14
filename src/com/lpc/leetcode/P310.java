package com.lpc.leetcode;

import java.util.*;

/**
 * 最小高度树
 *
 * @author byu_rself
 * @date 2023/3/26 20:32
 */
public class P310 {

    // 拓扑排序
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
            ++degree[e[0]];
            ++degree[e[1]];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        int remainNodes = n;
        while (remainNodes > 2) {
            int size = queue.size();
            remainNodes -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int v : g[cur]) {
                    --degree[v];
                    if (degree[v] == 1) queue.offer(v);
                }
            }
        }
        while (!queue.isEmpty()) ans.add(queue.poll());
        return ans;
    }

    // DFS
/*    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        int x = getLongestNode(0, parent, list); // 找距离0点最远的点x
        int y = getLongestNode(x, parent, list); // 找距离x点最远的点y
        // 求x与y之间的距离
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int d = path.size();
        if (d % 2 == 0) ans.add(path.get(d / 2 - 1));
        ans.add(path.get(d / 2));
        return ans;
    }

    private int getLongestNode(int target, int[] parent, List<Integer>[] list) {
        int n = list.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[target] = 0;
        dfs(target, dist, parent, list);
        int maxDist = 0, node = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                node = i;
            }
        }
        return node;
    }

    private void dfs(int target, int[] dist, int[] parent, List<Integer>[] list) {
        for (int v : list[target]) {
            if (dist[v] < 0) {
                dist[v] = dist[target] + 1;
                parent[v] = target;
                dfs(v, dist, parent, list);
            }
        }
    }*/

    // BFS
/*    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; ++i) list[i] = new ArrayList<>();
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        int x = getLongestNode(0, parent, list); // 找距离0点最远的点x
        int y = getLongestNode(x, parent, list); // 找距离x点最远的点y
        // 求x与y之间的距离
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int d = path.size();
        if (d % 2 == 0) ans.add(path.get(d / 2 - 1));
        ans.add(path.get(d / 2));
        return ans;
    }

    private int getLongestNode(int target, int[] parent, List<Integer>[] list) {
        int n = list.length;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(target);
        visited[target] = true;
        int node = -1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            node = cur;
            for (int v : list[cur]) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = cur;
                    queue.offer(v);
                }
            }
        }
        return node;
    }*/
}
