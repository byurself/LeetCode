package com.lpc.leetcode;

import org.junit.Test;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author byu_rself
 * @date 2022/5/17 8:57
 */
public class P28 {

    @Test
    public void solution() {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        haystack = " " + haystack;
        needle = " " + needle;
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        int[] next = new int[n + 1];
        // 求next数组
        for (int i = 2, j = 0; i <= n; ++i) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j]; // 匹配不成功
            if (p[i] == p[j + 1]) ++j; // 匹配成功
            next[i] = j;
        }
        // 模式匹配
        for (int i = 1, j = 0; i <= m; ++i) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j]; // 匹配不成功
            if (s[i] == p[j + 1]) ++j; // 匹配成功
            if (j == n) return i - n; // 整串匹配成功
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i + n < m; ++i) {
            boolean flag = true;
            for (int j = 0; j < n; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}
