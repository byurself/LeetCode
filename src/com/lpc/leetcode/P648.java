package com.lpc.leetcode;

import java.util.List;

/**
 * 单词替换
 *
 * @author byu_rself
 * @date 2023/5/10 9:48
 */
public class P648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) trie.insert(s);
        StringBuilder builder = new StringBuilder();
        for (String word : sentence.split(" ")) {
            builder.append(trie.query(word)).append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }

    private static class Trie {
        private Trie[] next;
        private boolean isEnd;

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

        public String query(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null) break;
                if (node.next[c - 'a'].isEnd) return word.substring(0, i + 1);
                node = node.next[c - 'a'];
            }
            return word;
        }
    }
}
