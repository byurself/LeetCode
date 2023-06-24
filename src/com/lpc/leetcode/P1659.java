package com.lpc.leetcode;

/**
 * 最大化网格幸福感
 *
 * @author byu_rself
 * @date 2023/6/24 13:28
 */
public class P1659 {

    int m, mx;
    int[] f, ix, ex;
    int[][] g, bits;
    Integer[][][][] cache;
    static final int[][] h = {{0, 0, 0}, {0, -60, -10}, {0, -10, 40}};

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        mx = (int) Math.pow(3, n);
        f = new int[mx];
        g = new int[mx][mx];
        bits = new int[mx][n];
        ix = new int[mx];
        ex = new int[mx];
        cache = new Integer[m][mx][introvertsCount + 1][extrovertsCount + 1];
        for (int i = 0; i < mx; ++i) {
            int mask = i;
            for (int j = 0; j < n; ++j) {
                int x = mask % 3;
                mask /= 3;
                bits[i][j] = x;
                if (x == 1) {
                    ix[i]++;
                    f[i] += 120;
                } else if (x == 2) {
                    ex[i]++;
                    f[i] += 40;
                }
                if (j > 0) {
                    f[i] += h[x][bits[i][j - 1]];
                }
            }
        }
        for (int i = 0; i < mx; ++i) {
            for (int j = 0; j < mx; ++j) {
                for (int k = 0; k < n; ++k) {
                    g[i][j] += h[bits[i][k]][bits[j][k]];
                }
            }
        }
        return dfs(0, 0, introvertsCount, extrovertsCount);
    }

    private int dfs(int i, int pre, int ic, int ec) {
        if (i == m || (ic == 0 && ec == 0)) return 0;
        if (cache[i][pre][ic][ec] != null) {
            return cache[i][pre][ic][ec];
        }
        int ans = 0;
        for (int cur = 0; cur < mx; ++cur) {
            if (ix[cur] <= ic && ex[cur] <= ec) {
                ans = Math.max(ans, f[cur] + g[pre][cur] + dfs(i + 1, cur, ic - ix[cur], ec - ex[cur]));
            }
        }
        return cache[i][pre][ic][ec] = ans;
    }
}
