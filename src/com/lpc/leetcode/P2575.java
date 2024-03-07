package com.lpc.leetcode;

/**
 * 找出字符串的可整除数组
 *
 * @author byu_rself
 * @date 2024/3/7 9:23
 */
public class P2575 {

    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long x = 0;
        /*
            设 a = k1 * m + r1, b = k2 * m + r2
            那么 (a + b) mod m = (r1 + r2) mod m = (a mod m + b mod m) mod m

            设[0, i - 1]表示的数为 k * m + r, [0, i]表示的数则为 10 * (k * m + r) + nums[i]
            则(10 * (k * m + r) + nums[i]) mod m = (10 * r + nums[i]) mod m
         */
        for (int i = 0; i < n; ++i) {
            x = (10 * x + word.charAt(i) - '0') % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
