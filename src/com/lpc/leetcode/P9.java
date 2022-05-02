package com.lpc.leetcode;

import org.junit.Test;

/**
 * @author byu_rself
 * @date 2022/5/2 21:11
 */
public class P9 {

    @Test
    public void solution() {
        int x = 123321;
        System.out.println(isPalindrome(x));
    }

    // 12321   123321
    public boolean isPalindrome(int x) {
        // 特殊情况处理：
        // 1、当 x < 0 时，x 不是回文数。
        // 2、如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是0，只有0满足这一属性
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindromeString(int x) {
        String s = x + "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
