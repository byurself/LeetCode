package com.lpc.leetcode;

/**
 * 叶值的最小代价生成树
 *
 * @author byu_rself
 * @date 2023/5/31 9:02
 */
public class P1130 {

    int[][] cache;
    int[][] g;

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        cache = new int[n][n];
        g = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            g[i][i] = arr[i];
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = Math.max(g[i][j - 1], arr[j]);
            }
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i == j) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            ans = Math.min(ans, dfs(i, k) + dfs(k + 1, j) + g[i][k] * g[k + 1][j]);
        }
        return cache[i][j] = ans;
    }
}
