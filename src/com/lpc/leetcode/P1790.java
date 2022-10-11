package com.lpc.leetcode;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author byu_rself
 * @date 2022/10/11 11:11
 */
public class P1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        int a = -1, b = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == -1) a = i;
                else if (b == -1) b = i;
                else return false;
            }
        }
        if (a == b && b == -1) return true;
        else if (b == -1) return false;
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }
}
