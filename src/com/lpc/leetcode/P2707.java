package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中的额外字符
 *
 * @author byu_rself
 * @date 2024/1/9 9:15
 */
public class P2707 {

    public int minExtraChar1(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String w : dictionary) {
            set.add(w);
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] + 1;
            for (int j = 0; j < i; ++j) {
                if (set.contains(s.substring(j, i))) {
                    f[i] = Math.min(f[i], f[j]);
                }
            }
        }
        return f[n];
    }

    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        int n = s.length();
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] + 1;
            Trie node = trie;
            for (int j = i - 1; j >= 0; --j) {
                node = node.children[s.charAt(j) - 'a'];
                if (node == null) break;
                if (node.isEnd && f[j] < f[i]) {
                    f[i] = f[j];
                }
            }
        }
        return f[n];
    }

    private static class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; --i) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }
    }
}
