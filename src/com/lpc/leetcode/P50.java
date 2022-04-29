package com.lpc.leetcode;

import java.util.Scanner;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数
 *
 * @author byu_rself
 * @date 2022/4/28 9:41
 */
public class P50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        // int范围 [−2147483648,2147483647]

        long N = n;

        System.out.printf("%.5f", N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N));
    }

    /**
     * 快速幂 + 迭代
     *
     * @param x
     * @param n
     * @return
     */
    private static double quickPow(double x, long n) {
        double result = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 n 进行二进制拆分的同时计算答案
        while (n > 0) {
            if (n % 2 == 1) {
                // 如果 n 二进制表示的最低位为 1，那么需要计入贡献
                result *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 n 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return result;
    }


    /**
     * 快速幂 + 递归
     *
     * @param x
     * @param n
     * @return
     */
    /*private static double quickPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1 || n == 0) {
            return 1.0;
        }
        double y = quickPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }*/

    /*private static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1 || n == 0) {
            return 1.0;
        }
        double result = 1.0;
        if (n > 0) {
            while (n-- > 0) {
                result *= x;
            }
        } else {
            while (n++ < 0) {
                result *= x;
            }
            result = 1 / result;
        }
        return result;
    }*/
}
