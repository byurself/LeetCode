package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 掷骰子等于目标和的方法数
 *
 * @author byu_rself
 * @date 2023/10/24 9:42
 */
public class P1155 {

    public int numRollsToTarget1(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        int[][] f = new int[n + 1][target - n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= target - n; ++j) {
                for (int x = 0; x < k && x <= j; ++x) {
                    f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                }
            }
        }
        return f[n][target - n];
    }

    private static final int MOD = (int) 1e9 + 7;
    int[][] cache;

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        cache = new int[n + 1][target - n + 1];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return dfs(n, target - n, k);
    }

    private int dfs(int i, int j, int k) {
        if (i == 0) {
            return j == 0 ? 1 : 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int ans = 0;
        for (int x = 0; x < k && x <= j; ++x) {
            ans = (ans + dfs(i - 1, j - x, k)) % MOD;
        }
        return cache[i][j] = ans;
    }
}
