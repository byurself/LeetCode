package com.lpc.leetcode;

import org.junit.Test;

/**
 * 字符串轮转
 *
 * @author byu_rself
 * @date 2022/9/29 0:07
 */
public class Interview0109 {

    @Test
    public void solution() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
    }

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
