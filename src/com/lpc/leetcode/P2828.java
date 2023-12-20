package com.lpc.leetcode;

import java.util.List;

/**
 * 判别首字母缩略词
 *
 * @author byu_rself
 * @date 2023/12/20 9:59
 */
public class P2828 {

    public boolean isAcronym(List<String> words, String s) {
        int n = words.size(), m = s.length();
        if (n != m) return false;
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word.charAt(0));
        }
        return builder.toString().equals(s);
    }
}
