package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 特殊的二进制序列
 *
 * @author byu_rself
 * @date 2022/8/8 0:33
 */
public class P761 {

    @Test
    public void solution() {
        String s = "11011000";
        System.out.println(makeLargestSpecial(s));
    }

    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0, left = 0, cnt = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String ss : list) {
            sb.append(ss);
        }
        return sb.toString();
    }
}
