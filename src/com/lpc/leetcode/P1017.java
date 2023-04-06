package com.lpc.leetcode;

import org.junit.Test;

/**
 * 负二进制转换
 *
 * @author byu_rself
 * @date 2023/4/6 13:46
 */
public class P1017 {

    @Test
    public void solution() {
        System.out.println(baseNeg2(7));
    }

    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int remainder = n % (-2);
            n /= -2;
            if (remainder < 0) {
                remainder += 2;
                ++n;
            }
            builder.append(remainder);
        }
        return builder.reverse().toString();
    }
}
