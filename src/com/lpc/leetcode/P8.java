package com.lpc.leetcode;

import org.junit.Test;

/**
 * 字符串转换整数 (atoi)
 *
 * @author byu_rself
 * @date 2022/5/5 9:06
 */
public class P8 {

    @Test
    public void solution() {
        String s = "-2147483647";
        System.out.println(myAtoi(s));
    }

    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        int index = 0;
        // 去除空格
        while (index < charArray.length && charArray[index] == ' ') {
            index++;
        }

        // 极端情况："          "
        if (index == charArray.length) {
            return 0;
        }

        // 判断符号
        int sign = 1;
        if (charArray[index] == '+') {
            index++;
        } else if (charArray[index] == '-') {
            index++;
            sign = -1;
        }

        int result = 0;
        while (index < charArray.length) {
            // 如果不是数字，直接结束
            if (charArray[index] < '0' || charArray[index] > '9') {
                break;
            }

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (charArray[index] - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (charArray[index] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + sign * (charArray[index] - '0');
            index++;
        }
        return result;
    }

}
