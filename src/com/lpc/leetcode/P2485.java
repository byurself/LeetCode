package com.lpc.leetcode;

/**
 * 找出中枢整数
 *
 * @author byu_rself
 * @date 2023/6/26 9:27
 */
public class P2485 {

    public int pivotInteger(int n) {
        for (int x = 1; x <= n; ++x) {
            int a = (1 + x) * x / 2;
            int b = (x + n) * (n - x + 1) / 2;
            if (a == b) return x;
        }
        return -1;
    }
}
