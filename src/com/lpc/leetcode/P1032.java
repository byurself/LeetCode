package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 字符流
 *
 * @author byu_rself
 * @date 2022/9/4 20:37
 */
public class P1032 {

    private StringBuilder builder;
    private Trie trie;

    public P1032(String[] words) {
        builder = new StringBuilder();
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public boolean query(char letter) {
        builder.append(letter);
        return trie.query(builder);
    }

    private static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        public void insert(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; --i) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean query(StringBuilder s) {
            Trie node = this;
            for (int i = s.length() - 1, j = 0; i >= 0 && j < 201; --i, ++j) {
                char c = s.charAt(i);
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
                if (node.isEnd) return true;
            }
            return false;
        }
    }

/*    private static int N = 2010 * 200, idx = 0;
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
    }*/
}
