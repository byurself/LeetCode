package com.lpc.leetcode;

import java.util.*;

/**
 * 收集树中金币
 *
 * @author byu_rself
 * @date 2023/9/21 10:12
 */
public class P2603 {

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] degree = new int[n];
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
            ++degree[x];
            ++degree[y];
        }
        int leftEdges = n - 1; // 剩余边数
        // 拓扑排序，去掉没有金币的子树
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 0) { // 没有金币的叶子
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            --leftEdges; // 删除节点到其父节点的边
            int x = q.poll();
            for (int y : g[x]) {
                if (--degree[y] == 1 && coins[y] == 0) { // 没有金币的叶子
                    q.offer(y);
                }
            }
        }

        // 再次拓扑排序
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 1) { // 有金币的叶子（判断 coins[i] 是避免把没有金币的叶子也算进来）
                q.offer(i);
            }
        }
        leftEdges -= q.size(); // 删除所有叶子（到其父节点的边）
        for (int x : q) { // 遍历所有叶子
            for (int y : g[x]) {
                if (--degree[y] == 1) { // y 现在是叶子了
                    --leftEdges; // 删除 y（到其父节点的边）
                }
            }
        }
        return Math.max(leftEdges * 2, 0);
    }
}
