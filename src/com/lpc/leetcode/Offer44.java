package com.lpc.leetcode;

/**
 * 数字序列中某一位的数字
 *
 * @author byu_rself
 * @date 2023/8/3 14:04
 */
public class Offer44 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while (n > count) {
            n -= count;
            digit += 1; // 位数：1,10,100...
            start *= 10; // 起始数字：1,2,3...
            count = digit * start * 9; // 数位数量:9,180,2700...
        }
        long num = start + (n - 1) / digit; // 确定数字
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
