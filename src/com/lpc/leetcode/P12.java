package com.lpc.leetcode;

import org.junit.Test;

/**
 * 整数转罗马数字
 *
 * @author byu_rself
 * @date 2022/5/9 9:33
 */
public class P12 {

    @Test
    public void solution() {
        int num = 3;
        System.out.println(intToRoman(num));
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
