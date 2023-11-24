package com.lpc.leetcode;

/**
 * 键值映射
 *
 * @author byu_rself
 * @date 2023/11/24 9:51
 */
public class P677 {

    Trie trie;

    public P677() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        Trie node = trie;
        for (int i = 0; i < prefix.length(); ++i) {
            int u = prefix.charAt(i) - 'a';
            if (node.next[u] == null) return 0;
            node = node.next[u];
        }
        return dfs(node);
    }

    private int dfs(Trie node) {
        if (node == null) return 0;
        int ans = node.val;
        for (Trie child : node.next) {
            ans += dfs(child);
        }
        return ans;
    }

    private static class Trie {
        Trie[] next;
        int val;

        public Trie() {
            next = new Trie[26];
            val = 0;
        }

        public void insert(String word, int val) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int u = word.charAt(i) - 'a';
                if (node.next[u] == null) {
                    node.next[u] = new Trie();
                }
                node = node.next[u];
            }
            node.val = val;
        }
    }
}
