package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小化旅行的价格总和
 *
 * @author byu_rself
 * @date 2023/12/6 10:18
 */
public class P2646 {

    List<Integer>[] g;
    int[] price, cnt;
    int end;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new ArrayList[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        cnt = new int[n];
        for (int[] trip : trips) {
            end = trip[1];
            dfs(trip[0], -1);
        }
        this.price = price;
        int[] ans = dp(0, -1);
        return Math.min(ans[0], ans[1]);
    }

    private int[] dp(int x, int pa) {
        int notHalve = price[x] * cnt[x];
        int halve = notHalve / 2;
        for (int y : g[x]) {
            if (y != pa) {
                int[] ans = dp(y, x); // 计算 y 不变/减半的最小价值总和
                notHalve += Math.min(ans[0], ans[1]); // x 不变，那么 y 可以不变，可以减半，取这两种情况的最小值
                halve += ans[0]; // x 减半，那么 y 只能不变
            }
        }
        return new int[]{notHalve, halve};
    }

    private boolean dfs(int x, int fa) {
        if (x == end) {
            ++cnt[x];
            return true;
        }
        for (int y : g[x]) {
            if (y != fa && dfs(y, x)) {
                ++cnt[x]; // x 是 end 的祖先节点，即在路径上
                return true;
            }
        }
        return false; // 未找到 end
    }
}
