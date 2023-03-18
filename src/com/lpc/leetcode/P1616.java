package com.lpc.leetcode;

/**
 * 分割两个字符串得到回文串
 *
 * @author byu_rself
 * @date 2023/3/18 13:34
 */
public class P1616 {

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            ++i;
            --j;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }
}
