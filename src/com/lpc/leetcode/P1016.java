package com.lpc.leetcode;

/**
 * 子串能表示从1到N数字的二进制串
 *
 * @author byu_rself
 * @date 2023/5/11 8:55
 */
public class P1016 {

    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; ++i) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }
}
