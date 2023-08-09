package com.lpc.leetcode;

/**
 * 整数的各位积和之差
 *
 * @author byu_rself
 * @date 2023/8/9 9:36
 */
public class P1281 {

    public int subtractProductAndSum(int n) {
        int prod = 1, sum = 0;
        while (n > 0) {
            int x = n % 10;
            n /= 10;
            prod *= x;
            sum += x;
        }
        return prod - sum;
    }
}
