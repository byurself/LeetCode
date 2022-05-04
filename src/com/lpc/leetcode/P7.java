package com.lpc.leetcode;

import org.junit.Test;

/**
 * 整数反转
 *
 * @author byu_rself
 * @date 2022/5/4 8:13
 */
public class P7 {

    @Test
    public void solution() {
        int x = 321;
        System.out.println(reverse(x));
    }

    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            if (n > Integer.MAX_VALUE / 10 || n < Integer.MIN_VALUE / 10)  {
                return 0;
            }
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n;
    }

}
