package com.lpc.leetcode;

import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 * @author byu_rself
 * @date 2023/2/28 11:24
 */
public class P524 {

    public String findLongestWord(String s, List<String> list) {
        int n = s.length();
        list.sort((a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length(); // 按字符串长度倒序
            return a.compareTo(b); // 按字典序升序
        });
        for (String ss : list) {
            int length = ss.length();
            int i = 0, j = 0;
            while (i < n && j < length) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == length) return ss;
        }
        return "";
    }
}
