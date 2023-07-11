package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 从英文中重建数字
 *
 * @author byu_rself
 * @date 2023/7/11 18:50
 */
public class P423 {

    static String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

    public String originalDigits(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; ++i) ++cnts[s.charAt(i) - 'a'];
        StringBuilder builder = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            char[] cs = nums[i].toCharArray();
            for (char c : cs) k = Math.min(k, cnts[c - 'a']);
            for (char c : cs) cnts[c - 'a'] -= k;
            while (k-- > 0) builder.append(i);
        }
        char[] cs = builder.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}
