package com.lpc.leetcode;

import org.junit.Test;

/**
 * 第N位数字
 *
 * @author byu_rself
 * @date 2023/7/2 19:08
 */
public class P400 {

    @Test
    public void solution() {
        System.out.println(findNthDigit(13));
    }

    public int findNthDigit(int n) {
        // 确定第n位数的长度
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            ++len;
        }
        // 先得到起点值
        // len = 2时，s = 10
        // len = 3时，s = 100
        long s = (long) Math.pow(10, len - 1);
        s += n / len - 1;
        n -= len * (n / len);
        return n == 0 ? (int) (s % 10) : (int) ((s + 1) / Math.pow(10, len - n) % 10);
    }
}
