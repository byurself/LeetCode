package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 两个相同字符之间的最长子字符串
 *
 * @author byu_rself
 * @date 2022/9/17 14:29
 */
public class P1624 {

    @Test
    public void solution() {
        String s = "cabbac";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] index = new int[26];
        Arrays.fill(index, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c - 'a'] < 0) {
                index[c - 'a'] = i;
            } else {
                ans = Math.max(ans, i - index[c - 'a'] - 1);
            }
        }
        return ans;
    }
}
