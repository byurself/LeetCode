package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 *
 * @author byu_rself
 * @date 2023/7/2 18:57
 */
public class P166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder builder = new StringBuilder();
        if (a * b < 0) {
            builder.append("-");
            a = Math.abs(a);
            b = Math.abs(b);
        }
        builder.append(a / b).append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, builder.length());
            a *= 10;
            builder.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int length = map.get(a);
                return String.format("%s(%s)", builder.substring(0, length), builder.substring(length));
            }
        }
        return builder.toString();
    }

    public String fractionToDecimal1(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder builder = new StringBuilder();
        // 其中一个数为负数，先加负号
        if (a * b < 0) {
            builder.append('-');
            a = Math.abs(a);
            b = Math.abs(b);
        }
        // 计算小数点前的部分，并将余数赋值给 a
        builder.append(a / b).append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, builder.length());
            a *= 10;
            builder.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int length = map.get(a);
                return String.format("%s(%s)" , builder.substring(0, length), builder.substring(length));
            }
        }
        return builder.toString();
    }
}
