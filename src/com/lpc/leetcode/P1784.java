package com.lpc.leetcode;

/**
 * 检查二进制字符串字段
 *
 * @author byu_rself
 * @date 2022/10/3 22:14
 */
public class P1784 {

    public boolean checkOnesSegment(String s) {
        int length = s.length(), i = 0, cnt = 0;
        while (i < length) {
            while (i < length && s.charAt(i) == '0') i++;
            if (i < length) {
                while (i < length && s.charAt(i) == '1') i++;
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
