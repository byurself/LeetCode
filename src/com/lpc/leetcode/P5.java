package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最长回文子串
 *
 * @author byu_rself
 * @date 2022/4/30 23:20
 */
public class P5 {
    @Test
    public void solution() {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 方法四：中心扩展
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 方法三：动态规划优化
     * 时间复杂度O(n²)
     * 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public String dpLongestPalindrome2(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 方法二：动态规划
     * 时间复杂度O(n²)
     * 空间复杂度O(n²)
     *
     * @param s
     * @return
     */
    public String dpLongestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) // 遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) // 下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); // 长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    /**
     * 方法一：暴力求解
     *
     * @param s
     * @return
     */
    public String blLongestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        String result = "";
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && max < substring.length()) {
                    max = substring.length();
                    result = substring;
                }
            }
        }
        return result;
    }

    /**
     * 判断是否为回文
     *
     * @param s 字符串s
     * @return 是/否
     */
    public Boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
