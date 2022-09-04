package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 字符流
 *
 * @author byu_rself
 * @date 2022/9/4 20:37
 */
public class P1032 {

    private static int N = 2010 * 200, idx = 0;
    private static int[][] trie = new int[N][26];
    private static boolean[] isEnd = new boolean[N * 26];
    StringBuilder sb = new StringBuilder();

    private void insert(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (trie[p][index] == 0) trie[p][index] = ++idx;
            p = trie[p][index];
        }
        isEnd[p] = true;
    }

    private boolean query(int start, int end) {
        int p = 0;
        for (int i = start; i <= end; i++) {
            int index = sb.charAt(i) - 'a';
            if (trie[p][index] == 0) return false;
            p = trie[p][index];
        }
        return isEnd[p];
    }

    public P1032(String[] words) {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(trie[i], 0);
            isEnd[i] = false;
        }
        for (String s : words) insert(s);
    }

    public boolean query(char c) {
        sb.append(c);
        int n = sb.length(), min = Math.max(0, n - 200);
        for (int i = n - 1; i >= min; i--) {
            if (query(i, n - 1)) return true;
        }
        return false;
    }
}
