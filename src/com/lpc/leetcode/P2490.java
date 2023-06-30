package com.lpc.leetcode;

/**
 * 回环句
 *
 * @author byu_rself
 * @date 2023/6/30 9:10
 */
public class P2490 {

    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(n - 1)) return false;
        for (int i = 1; i < n; ++i) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCircularSentence1(String sentence) {
        String[] s = sentence.trim().split(" ");
        int n = s.length;
        for (int i = 0; i < n; ++i) {
            if (s[i].charAt(s[i].length() - 1) != s[(i + 1) % n].charAt(0)) return false;
        }
        return true;
    }
}
