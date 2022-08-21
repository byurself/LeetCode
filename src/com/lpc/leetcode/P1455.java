package com.lpc.leetcode;

/**
 * 检查单词是否为句中其他单词的前缀
 *
 * @author byu_rself
 * @date 2022/8/21 10:27
 */
public class P1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        int searchLength = searchWord.length();
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < searchWord.length()) continue;
            boolean flag = true;
            for (int j = 0; j < searchLength; j++) {
                if (s[i].charAt(j) != searchWord.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i + 1;

        }
        return -1;
    }
}
