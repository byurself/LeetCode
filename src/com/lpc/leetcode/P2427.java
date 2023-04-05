package com.lpc.leetcode;

/**
 * 公因子的数目
 *
 * @author byu_rself
 * @date 2023/4/5 16:16
 */
public class P2427 {

    public int commonFactors(int a, int b) {
        int ans = 0;
        int g = gcd(a, b);
        for (int i = 1; i * i <= g; ++i) {
            if (g % i == 0) {
                ++ans;
                if (i * i != g) ++ans; // x != c/x
            }
        }
        return ans;
    }

    public int commonFactors2(int a, int b) {
        int ans = 0;
        int g = gcd(a, b);
        for (int i = 1; i <= g; ++i) {
            if (g % i == 0) ++ans;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int commonFactors1(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= Math.min(a, b); ++i) {
            if (a % i == 0 && b % i == 0) ++ans;
        }
        return ans;
    }
}
