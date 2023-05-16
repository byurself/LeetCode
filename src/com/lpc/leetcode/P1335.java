package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 工作计划的最低难度
 *
 * @author byu_rself
 * @date 2023/5/16 9:06
 */
public class P1335 {

    int[] jobDifficulty;
    int[][] cache;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        this.jobDifficulty = jobDifficulty;
        this.cache = new int[d][n];
        for (int i = 0; i < d; ++i) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(d - 1, n - 1);
    }

    /**
     * dfs(i,j)表示用i+1天完成0~j天的工作
     */
    private int dfs(int i, int j) {
        if (cache[i][j] != -1) return cache[i][j];
        // 只有一天，必须完成所有工作
        if (i == 0) {
            int max = 0;
            for (int k = 0; k <= j; ++k) {
                max = Math.max(max, jobDifficulty[k]);
            }
            return cache[i][j] = max;
        }
        int max = 0, ans = Integer.MAX_VALUE;
        for (int k = j; k >= i; --k) {
            max = Math.max(max, jobDifficulty[k]);
            ans = Math.min(ans, dfs(i - 1, k - 1) + max);
        }
        return cache[i][j] = ans;
    }

/*    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] f = new int[d][n];
        f[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; ++i) {
            f[0][i] = Math.max(f[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; ++i) {
            for (int j = n - 1; j >= i; --j) {
                f[i][j] = Integer.MAX_VALUE;
                int max = 0;
                for (int k = j; k >= i; --k) {
                    max = Math.max(max, jobDifficulty[k]);
                    f[i][j] = Math.min(f[i][j], f[i - 1][k - 1] + max);
                }
            }
        }
        return f[d - 1][n - 1];
    }*/
}
