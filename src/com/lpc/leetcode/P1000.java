package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 合并石头的最低成本
 *
 * @author byu_rself
 * @date 2023/4/4 11:21
 */
public class P1000 {

    int[][] cache;
    int[] s;
    int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) return -1; // 无法合并成一堆
        s = new int[n + 1];
        for (int i = 1; i <= n; ++i) s[i] = s[i - 1] + stones[i - 1];
        this.k = k;
        cache = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(cache[i], -1); // -1表示还没计算过
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i == j) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        int ans = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            ans = Math.min(ans, dfs(i, m) + dfs(m + 1, j));
        }
        if ((j - i) % (k - 1) == 0) {
            // 可以合并成一堆
            ans += s[j + 1] - s[i];
        }
        return cache[i][j] = ans;
    }

/*    int[][][] cache;
    int[] s;
    int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) return -1; // 无法合并成一堆
        s = new int[n + 1];
        for (int i = 1; i <= n; ++i) s[i] = s[i - 1] + stones[i - 1];
        this.k = k;
        cache = new int[n][n][k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(cache[i][j], -1); // -1表示还没计算过
            }
        }
        return dfs(0, n - 1, 1);
    }

    *//**
     * 表示把stones[i]~stones[j]合并成p堆的最低成本
     *//*
    private int dfs(int i, int j, int p) {
        if (cache[i][j][p] != -1) return cache[i][j][p];
        // 合并成一堆
        if (p == 1) {
            // 如果只有一堆，则无需合并，成本为0
            // 否则，计算从i~j合并成k堆的最小成本
            return cache[i][j][p] = i == j ? 0 : dfs(i, j, k) + s[j + 1] - s[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            ans = Math.min(ans, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }
        return cache[i][j][p] = ans;
    }*/
}
