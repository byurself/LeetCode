package com.lpc.leetcode;

/**
 * 最大为 N 的数字组合
 *
 * @author byu_rself
 * @date 2022/10/18 0:18
 */
public class P902 {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int length = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= k; i++) {
            for (String digit : digits) {
                char d = digit.charAt(0), c = s.charAt(i - 1);
                if (d == c) dp[i][1] = dp[i - 1][1];
                else if (d < c) dp[i][0] += dp[i - 1][1];
                else break;
            }
            if (i > 1) dp[i][0] += length + dp[i - 1][0] * length;
        }
        return dp[k][0] + dp[k][1];
    }
}
