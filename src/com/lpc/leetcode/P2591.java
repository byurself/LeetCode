package com.lpc.leetcode;

/**
 * 将钱分给最多的儿童
 *
 * @author byu_rself
 * @date 2023/9/22 9:35
 */
public class P2591 {

    public int distMoney(int money, int children) {
        if (money < children) return -1;
        if (money > 8 * children) return children - 1;
        if (money == 8 * children - 4) return children - 2;
        return (money - children) / 7;
    }
}
