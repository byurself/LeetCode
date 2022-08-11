package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 重新格式化字符串
 *
 * @author byu_rself
 * @date 2022/8/11 8:49
 */
public class P1417 {

    @Test
    public void solution() {
        String s = "covid2019";
        System.out.println(reformat(s));
    }

    public String reformat(String s) {
        List<Character> charList = new ArrayList<>();
        List<Character> digitList = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charList.add(c);
            } else {
                digitList.add(c);
            }
        }

        int cSize = charList.size(), dSize = digitList.size();
        if (Math.abs(cSize - dSize) > 1) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        boolean flag = cSize >= dSize;

        while (i < cSize || j < dSize) {
            if (flag) {
                sb.append(charList.get(i++));
                flag = false;
            } else {
                sb.append(digitList.get(j++));
                flag = true;
            }
        }
        return sb.toString();
    }
}
