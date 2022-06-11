package com.lpc.leetcode;

import org.junit.Test;

/**
 * Flip String to Monotone Increasing
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

    public int minFlipsMonoIncr(String s) {
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
