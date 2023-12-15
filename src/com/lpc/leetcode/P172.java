package com.lpc.leetcode;

/**
 * 阶乘后的零
 *
 * @author byu_rself
 * @date 2023/12/15 10:58
 */
public class P172 {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n / 5;
            n = n / 5;
        }
        return ans;
    }
}
