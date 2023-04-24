package com.lpc.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 按字典序排在最后的子串
 *
 * @author byu_rself
 * @date 2023/4/24 14:17
 */
public class P1163 {

    @Test
    public void solution() {
        String s = "abab";
        System.out.println(lastSubstring(s));
    }

    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;
        while (j + k < n) {
            int d = s.charAt(i + k) - s.charAt(j + k);
            if (d == 0) {
                ++k;
            } else if (d < 0) {
                i = i + k + 1;
                k = 0;
                if (i >= j) j = i + 1;
            } else {
                j = j + k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
