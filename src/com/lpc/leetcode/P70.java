package com.lpc.leetcode;

/**
 * 爬楼梯
 *
 * @author byu_rself
 * @date 2023/12/11 14:03
 */
public class P70 {

    public int climbStairs(int n) {
        int a = 1, b = 1, c;
        for (int i = 2; i <= n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

/*    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }*/

    /*int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int i) {
        if (i <= 1) return 1;
        if (cache[i] != 0) return cache[i];
        return cache[i] = dfs(i - 1) + dfs(i - 2);
    }*/
}
