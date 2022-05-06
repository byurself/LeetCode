package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author byu_rself
 * @date 2022/5/6 14:36
 */
public class P13 {

    @Test
    public void solution() {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            int n = map.get(s.charAt(i));
            // 前一个字符比后一个字符小，则减去前一个字符 如IV
            if (i < length - 1 && n < map.get(s.charAt(i + 1))) {
                result -= n;
            } else {
                result += n;
            }
        }
        return result;
    }
}
