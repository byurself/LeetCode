package com.lpc.leetcode;

/**
 * 交替数字和
 *
 * @author byu_rself
 * @date 2023/7/12 9:12
 */
public class P2544 {

    public int alternateDigitSum(int n) {
        int ans = 0, sign = 1;
        for (char c : String.valueOf(n).toCharArray()) {
            int x = c - '0';
            ans += sign * x;
            sign *= -1;
        }
        return ans;
    }
}
