package com.lpc.leetcode;

/**
 * 多边形三角剖分的最低得分
 *
 * @author byu_rself
 * @date 2023/4/1 22:22
 */
public class P1039 {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int i = n - 3; i >= 0; --i) {
            for (int j = i + 2; j < n; ++j) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return f[0][n - 1];
    }

    int[] v;
    int[][] cache;

    public int minScoreTriangulation1(int[] values) {
        v = values;
        int n = values.length;
        cache = new int[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j) return 0; // 只有两个点，无法组成三角形
        if (cache[i][j] != 0) return cache[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) { // 枚举顶点k
            ans = Math.min(ans, dfs(i, k) + dfs(k, j) + v[i] * v[j] * v[k]);
        }
        return cache[i][j] = ans;
    }
}
