package com.lpc.leetcode;

/**
 * 到达终点数字
 *
 * @author byu_rself
 * @date 2022/11/4 10:25
 */
public class P754 {

    public int reachNumber(int target) {
        int result = 0, num = 0, t = Math.abs(target); // 由于target有负数情况，为了统一计算逻辑，所以取绝对值
        // 直到num值大于等于t，并且num减t是偶数，才结束while循环
        while (num < t || (num - t) % 2 != 0)
            num += ++result; // num=1+2+3+4+……
        return result;
    }
}
