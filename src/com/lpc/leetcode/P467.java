package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unique Substrings in Wraparound String
 *
 * @author byu_rself
 * @date 2022/5/25 18:59
 */
public class P467 {

    @Test
    public void solution() {
        String p = "zab";
        System.out.println(findSubstringInWraproundString(p));
    }

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}
