package com.lpc.leetcode;

/**
 * 最小偶倍数
 *
 * @author byu_rself
 * @date 2023/4/21 15:54
 */
public class P2413 {

    public int smallestEvenMultiple(int n) {
        return n << (n & 1);
    }

    public int smallestEvenMultiple1(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
