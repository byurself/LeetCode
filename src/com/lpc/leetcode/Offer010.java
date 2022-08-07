package com.lpc.leetcode;

import org.junit.Test;

/**
 * 斐波那契数列
 *
 * @author byu_rself
 * @date 2022/8/8 0:47
 */
public class Offer010 {

    @Test
    public void solution() {
        int n = 100;
        System.out.println(fib2(n));
    }

    static final int mod = (int) 1e9 + 7;

    /**
     * 动态规划
     */
    public int fib1(int n) {
        if (n <= 1) return n;
        int f1 = 0, f2 = 1, fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (f1 + f2) % mod;
            f1 = f2;
            f2 = fn;
        }
        return f2;
    }

    static int[] caches = new int[101];

    /**
     * 递归实现动态规划
     */
    public int fib2(int n) {
        if (n <= 1) return n;
        if (caches[n] != 0) return caches[n];
        caches[n] = (fib2(n - 1) + fib2(n - 2)) % mod;
        return caches[n];
    }

    /**
     * 打表
     */
    static int N = 101;
    static int[] cache = new int[N];

    static {
        cache[1] = 1;
        for (int i = 2; i < N; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % mod;
        }
    }

    public int fib3(int n) {
        return cache[n];
    }

    /**
     * 矩阵快速幂
     */
    public int fib4(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % mod);
            }
        }
        return c;
    }
}
