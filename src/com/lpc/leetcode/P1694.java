package com.lpc.leetcode;

import org.junit.Test;

/**
 * 重新格式化电话号码
 *
 * @author byu_rself
 * @date 2022/10/1 0:17
 */
public class P1694 {

    @Test
    public void solution() {
        String number = "1-23-45 6";
        System.out.println(reformatNumber(number));
    }

    public String reformatNumber(String number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        int n = builder.length(), index = 0;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                ans.append(builder.substring(index, index + 3)).append("-");
                index += 3;
                n -= 3;
            } else {
                if (n == 4) {
                    ans.append(builder.substring(index, index + 2)).append("-").append(builder.substring(index + 2, index + 4));
                } else {
                    ans.append(builder.substring(index, index + n));
                }
                break;
            }
        }
        return ans.toString();
    }

    public String reformatNumber1(String number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }

        int length = builder.length();
        if (length <= 3) return builder.toString();
        else {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < length; ) {
                int res = length - i;
                if (res > 4) {
                    ans.append(builder.substring(i, i + 3)).append("-");
                    i += 3;
                } else if (res == 4) {
                    ans.append(builder.substring(i, i + 2)).append("-").append(builder.substring(i + 2, i + 4));
                    break;
                } else if (res == 3) {
                    ans.append(builder.substring(i, i + 3));
                    break;
                } else if (res == 2) {
                    ans.append(builder.substring(i, i + 2));
                    break;
                }
            }
            return ans.toString();
        }
    }
}
