package com.lpc.leetcode;

/**
 * 实现一个魔法字典
 *
 * @author byu_rself
 * @date 2023/5/28 15:48
 */
public class P676 {

    Trie node;

    public P676() {
        node = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) node.insert(s);
    }

    public boolean search(String searchWord) {
        return node.query(searchWord, node, 0, false);
    }

    private static class Trie {
        Trie[] next;
        boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean query(String word, Trie node, int pos, boolean modified) {
            if (pos == word.length()) return node.isEnd && modified;
            int idx = word.charAt(pos) - 'a';
            if (node.next[idx] != null) {
                if (query(word, node.next[idx], pos + 1, modified)) return true;
            }
            if (!modified) {
                for (int i = 0; i < 26; ++i) {
                    if (i != idx && node.next[i] != null) {
                        if (query(word, node.next[i], pos + 1, true)) return true;
                    }
                }
            }
            return false;
        }
    }
}
