package com.lpc.leetcode;

import org.junit.Test;

/**
 * @author byu_rself
 * @date 2022/8/1 8:28
 */
public class P1374 {

    @Test
    public void solution() {
        int n = 4;
        System.out.println(generateTheString(n));
    }

    public String generateTheString(int n) {
        return n % 2 == 0 ? "a".repeat(n - 1) + "b" : "a".repeat(n);
    }
}
