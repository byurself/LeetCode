package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 连接词
 *
 * @author byu_rself
 * @date 2023/6/5 13:51
 */
public class P472 {

    Trie trie;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        trie = new Trie();
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            int n = word.length();
            if (n == 0) continue;
            boolean[] visited = new boolean[n];
            if (dfs(word, 0, visited)) ans.add(word);
            else trie.insert(word);
        }
        return ans;
    }

    private boolean dfs(String word, int start, boolean[] visited) {
        if (word.length() == start) return true;
        if (visited[start]) return false;
        visited[start] = true;
        Trie node = trie;
        for (int i = start; i < word.length(); ++i) {
            int u = word.charAt(i) - 'a';
            node = node.next[u];
            if (node == null) return false;
            if (node.isEnd) {
                if (dfs(word, i + 1, visited)) {
                    return true;
                }
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

        public void insert(String word) {
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
