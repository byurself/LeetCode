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
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        // 使下标从 1 开始
        haystack = " " + haystack;
        needle = " " + needle;
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        // 求 next 数组，next 数组与模式串（匹配串）相关
        int[] next = new int[m + 1];
        for (int i = 1, j = 0; i < m; ) {
            if (j == 0 || p[i] == p[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j]; // 匹配失败
            }
        }
        // KMP模式匹配
        int i = 1, j = 1;
        while (i <= n && j <= m) {
            if (j == 0 || s[i] == p[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j > m) return i - m - 1; // 匹配成功
        else return -1;
    }

    /*public int strStr(String haystack, String needle) {
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
    }*/

    /*public int strStr1(String haystack, String needle) {
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
    }*/
}
