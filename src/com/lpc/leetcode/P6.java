package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 * @author byu_rself
 * @date 2022/5/3 12:55
 */
public class P6 {

    @Test
    public void solution() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || numRows >= length) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            // 如果当前位于第一行或最后一行，改变方向
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : list) {
            result.append(row);
        }
        return result.toString();
    }
}
