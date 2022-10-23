package com.lpc.leetcode;

/**
 * 交替合并字符串
 *
 * @author byu_rself
 * @date 2022/10/23 11:28
 */
public class P1768 {

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) builder.append(word1.charAt(i++));
            if (j < word2.length()) builder.append(word2.charAt(j++));
        }
        return builder.toString();
    }

    public String mergeAlternately1(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0, flag = 1;
        while (i < word1.length() && j < word2.length()) {
            if (flag == 1) {
                builder.append(word1.charAt(i++));
            } else {
                builder.append(word2.charAt(j++));
            }
            flag *= -1;
        }
        while (i < word1.length()) builder.append(word1.charAt(i++));
        while (j < word2.length()) builder.append(word2.charAt(j++));
        return builder.toString();
    }
}
