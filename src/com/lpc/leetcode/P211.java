package com.lpc.leetcode;

/**
 * 添加与搜索单词-数据结构设计
 *
 * @author byu_rself
 * @date 2023/9/25 13:51
 */
public class P211 {

    Trie trie;

    public P211() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, trie);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) return node.isEnd;
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                Trie child = node.next[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        } else {
            int u = c - 'a';
            Trie child = node.next[u];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }
        return false;
    }

    private static class Trie {
        Trie[] next;
        boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void add(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int u = word.charAt(i) - 'a';
                if (node.next[u] == null) {
                    node.next[u] = new Trie();
                }
                node = node.next[u];
            }
            node.isEnd = true;
        }
    }
}
