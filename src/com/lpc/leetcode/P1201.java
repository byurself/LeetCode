package com.lpc.leetcode;

/**
 * 丑数III
 *
 * @author byu_rself
 * @date 2023/10/12 11:00
 */
public class P1201 {

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(a, lcm(b, c));
        long left = 0, right = (long) Math.min(a, Math.min(b, c)) * n;
        while (left < right) {
            long mid = left + right >> 1;
            if (mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc >= n) right = mid;
            else left = mid + 1;
        }
        return (int) right;
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公约数
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
