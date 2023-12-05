package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 到达首都的最少油耗
 *
 * @author byu_rself
 * @date 2023/12/5 9:26
 */
public class P2477 {

    List<Integer>[] g;
    int seats;
    long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;
        int n = roads.length + 1;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private int dfs(int x, int pa) {
        int size = 1;
        for (int y : g[x]) {
            // 递归子节点，统计子树大小
            if (y != pa) {
                size += dfs(y, x);
            }
        }
        // x 不是根节点
        if (x > 0) {
            ans += (size - 1) / seats + 1;
        }
        return size;
    }
}
