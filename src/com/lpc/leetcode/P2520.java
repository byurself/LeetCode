package com.lpc.leetcode;

/**
 * 统计能整除数字的位数
 *
 * @author byu_rself
 * @date 2023/10/26 8:55
 */
public class P2520 {

    public int countDigits(int num) {
        int x = num, ans = 0;
        while (x > 0) {
            int val = x % 10;
            if (num % val == 0) ++ans;
            x /= 10;
        }
        return ans;
    }
}
