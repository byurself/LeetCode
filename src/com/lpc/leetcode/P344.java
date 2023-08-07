package com.lpc.leetcode;

/**
 * 反转字符串
 *
 * @author byu_rself
 * @date 2023/8/7 9:36
 */
public class P344 {

    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
