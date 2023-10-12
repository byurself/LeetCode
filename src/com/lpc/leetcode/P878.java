package com.lpc.leetcode;

/**
 * 第N个神奇数字
 *
 * @author byu_rself
 * @date 2023/10/12 10:51
 */
public class P878 {

    private static final int MOD = (int) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        // 最大公倍数
        int c = a * b / gcd(a, b);
        long left = 0, right = (long) Math.min(a, b) * n;
        while (left < right) {
            long mid = left + right >> 1;
            // 容斥原理
            if (mid / a + mid / b - mid / c >= n) right = mid;
            else left = mid + 1;
        }
        return (int) right % MOD;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
