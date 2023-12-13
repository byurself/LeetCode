package com.lpc.leetcode;

/**
 * 字典序最小回文串
 *
 * @author byu_rself
 * @date 2023/12/13 10:05
 */
public class P2697 {

    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; ++i, --j) {
            cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
        }
        return new String(cs);
    }
}
