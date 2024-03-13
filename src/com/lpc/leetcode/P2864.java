package com.lpc.leetcode;

/**
 * 最大二进制奇数
 *
 * @author byu_rself
 * @date 2024/3/13 10:56
 */
public class P2864 {

    public String maximumOddBinaryNumber(String s) {
        int cnt1 = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            cnt1 += s.charAt(i) == '1' ? 1 : 0;
        }
        return "1".repeat(cnt1 - 1) + "0".repeat(n - cnt1) + "1";
    }
}
