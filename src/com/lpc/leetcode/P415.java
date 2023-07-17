package com.lpc.leetcode;

import org.junit.Test;

/**
 * 字符串相加
 *
 * @author byu_rself
 * @date 2023/7/17 9:20
 */
public class P415 {

    @Test
    public void solution() {
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        for (int carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j) {
            if (i >= 0) carry += num1.charAt(i);
            if (j >= 0) carry += num2.charAt(j);
            builder.append(carry % 10);
            carry /= 10; // 进位
        }
        return builder.reverse().toString();
    }

    // 高精度加法模板
    /*public String addStrings(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] A = new int[n], B = new int[m];
        for (int i = n - 1, j = 0; i >= 0; --i, ++j) A[j] = num1.charAt(i) - '0';
        for (int i = m - 1, j = 0; i >= 0; --i, ++j) B[j] = num2.charAt(i) - '0';

        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n || i < m; ++i) {
            if (i < n) carry += A[i];
            if (i < m) carry += B[i];
            builder.append(carry % 10);
            carry /= 10; // 进位
        }
        // 如果最高位还有进位，则在最高位添加1
        if (carry > 0) builder.append(1);
        return builder.reverse().toString();
    }*/
}
