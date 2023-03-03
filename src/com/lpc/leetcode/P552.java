package com.lpc.leetcode;

import org.junit.Test;

/**
 * 学生出勤记录 II
 *
 * @author byu_rself
 * @date 2023/3/3 10:55
 */
public class P552 {

    @Test
    public void solution() {
        System.out.println(checkRecord(10101));
    }


    private static final int MOD = (int) 1e9 + 7;

    public int checkRecord(int n) {
        long[][][] dp = new long[n][2][3];
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }
        return (int) ans;
    }


    private int[][][] cache;

    public int checkRecord1(int n) {
        cache = new int[n][2][3];
        return dfs(0, n, 0, 0);
    }

    private int dfs(int day, int n, int absent, int late) {
        if (day >= n) return 1;
        if (cache[day][absent][late] != 0) return cache[day][absent][late];
        int ans = 0;
        ans = (ans + dfs(day + 1, n, absent, 0)) % MOD;
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0)) % MOD;
        }
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1)) % MOD;
        }
        cache[day][absent][late] = ans;
        return ans;
    }
}
