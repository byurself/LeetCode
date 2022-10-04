package com.lpc.leetcode;

/**
 * 使括号有效的最少添加
 *
 * @author byu_rself
 * @date 2022/10/4 12:13
 */
public class P921 {

    public int minAddToMakeValid(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') l++;
            else {
                if (l > 0) l--;
                else r++;
            }
        }
        return l + r;
    }
}
