package com.lpc.leetcode;

import org.junit.Test;

/**
 * 在LR字符串中交换相邻字符
 *
 * @author byu_rself
 * @date 2022/10/2 18:31
 */
public class P777 {

    @Test
    public void solution() {
        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        System.out.println(canTransform(start, end));
    }

    public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) return i == j;
            char sc = start.charAt(i);
            char ec = end.charAt(j);
            if (sc != ec) return false;
            if (sc == 'L' && i < j) return false;
            if (sc == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }
}
