package com.lpc.leetcode;

/**
 * 第 N 个泰波那契数
 *
 * @author byu_rself
 * @date 2023/3/3 10:35
 */
public class P1137 {

    static int[] cache = new int[38];

    static {
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i <= 37; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
    }

    public int tribonacci(int n) {
        return cache[n];
    }

    // int[] cache = new int[38];
    //
    // public int tribonacci(int n) {
    //     if (n == 0) return 0;
    //     if (n == 1 || n == 2) return 1;
    //     if (cache[n] != 0) return cache[n];
    //     cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    //     return cache[n];
    // }

    public int tribonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int T0 = 0, T1 = 1, T2 = 1;
        for (int i = 3; i <= n; i++) {
            int s = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = s;
        }
        return T2;
    }
}
