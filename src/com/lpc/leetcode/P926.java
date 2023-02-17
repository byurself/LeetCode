package com.lpc.leetcode;

import org.junit.Test;

/**
 * 将字符串翻转到单调递增
 *
 * @author byu_rself
 * @date 2022/6/11 21:53
 */
public class P926 {

    @Test
    public void solution() {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }

    public int minFlipsMonoIncr1(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0 + (c == '1' ? 1 : 0);
            int dp1New = Math.min(dp0, dp1) + (c == '0' ? 1 : 0);
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            dp[i + 1][0] = dp[i][0] + (c == '1' ? 1 : 0);
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]) + (c == '0' ? 1 : 0);
        }
        return Math.min(dp[n][0], dp[n][1]);
    }

    public int minFlipsMonoIncr0(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }
}
