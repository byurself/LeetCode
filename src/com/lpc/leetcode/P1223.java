package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 掷骰子模拟
 *
 * @author byu_rself
 * @date 2023/2/10 15:58
 */
public class P1223 {

    private static final long MOD = (long) 1e9 + 7;
    private int[] rollMax;
    private int[][][] cache;

    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax = rollMax;
        int m = rollMax.length;
        long ans = 0;
        cache = new int[n][m][15];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; ++j) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        for (int j = 0; j < m; ++j) {
            ans += dfs(n - 1, j, rollMax[j] - 1);
        }
        return (int) (ans % MOD);
    }

    private int dfs(int i, int last, int left) {
        if (i == 0) return 1;
        if (cache[i][last][left] >= 0) return cache[i][last][left];
        long res = 0;
        for (int j = 0; j < rollMax.length; ++j) {
            if (j != last) res += dfs(i - 1, j, rollMax[j] - 1);
            else if (left > 0) res += dfs(i - 1, j, left - 1);
        }
        return cache[i][last][left] = (int) (res % MOD);
    }
}
