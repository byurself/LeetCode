package com.lpc.leetcode;

/**
 * 猜数字大小II
 *
 * @author byu_rself
 * @date 2023/8/23 10:05
 */
public class P375 {

    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 10][n + 10];
        for (int len = 2; len <= n; ++len) {
            for (int l = 1; l + len - 1 <= n; ++l) {
                int r = l + len - 1;
                f[l][r] = Integer.MAX_VALUE;
                for (int x = l; x <= r; ++x) {
                    int cur = Math.max(f[l][x - 1], f[x + 1][r]) + x;
                    f[l][r] = Math.min(f[l][r], cur);
                }
            }
        }
        return f[1][n];
    }

    /*int[][] cache;

    public int getMoneyAmount(int n) {
        cache = new int[n + 1][n + 1];
        return dfs(1, n);
    }

    private int dfs(int l, int r) {
        if (l >= r) return 0;
        if (cache[l][r] != 0) return cache[l][r];
        int ans = Integer.MAX_VALUE;
        for (int x = l; x <= r; ++x) {
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            ans = Math.min(ans, cur);
        }
        return cache[l][r] = ans;
    }*/
}
