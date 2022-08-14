package com.lpc.leetcode;

import org.junit.Test;

/**
 * 割字符串的最大得分
 *
 * @author byu_rself
 * @date 2022/8/14 14:47
 */
public class P1422 {

    @Test
    public void solution() {
        String s = "011101";
        System.out.println(maxScore(s));
    }

    public int maxScore(String s) {
        int n = s.length();
        int score = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') score++;
        }

        int ans = score;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') score++;
            else score--;
            ans = Math.max(ans, score);
        }
        return ans;
    }
}
