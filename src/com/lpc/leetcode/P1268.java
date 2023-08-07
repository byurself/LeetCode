package com.lpc.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 搜索推荐系统
 *
 * @author byu_rself
 * @date 2023/8/7 9:43
 */
public class P1268 {

    @Test
    public void solution() {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        for (List<String> product : suggestedProducts(products, searchWord)) {
            product.forEach(System.out::println);
        }

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.sort(products);
        for (int i = 0; i < products.length; ++i) trie.insert(products[i], i);
        List<List<String>> ans = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < searchWord.length(); ++i) {
            prefix.append(searchWord.charAt(i));
            List<String> list = new ArrayList<>();
            int[] query = trie.query(prefix);
            int left = query[0], right = query[1];
            if (left != -1) {
                for (int j = left; j <= Math.min(left + 2, right); ++j) list.add(products[j]);
            }
            ans.add(list);
        }
        return ans;
    }

    private static class Trie {
        Trie[] next;
        boolean isEnd;
        Map<Trie, Integer> minMap = new HashMap<>();
        Map<Trie, Integer> maxMap = new HashMap<>();

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String word, int index) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                int u = word.charAt(i) - 'a';
                if (node.next[u] == null) {
                    node.next[u] = new Trie();
                    minMap.put(node.next[u], index);
                }
                maxMap.put(node.next[u], index);
                node = node.next[u];
            }
            node.isEnd = true;
        }

        public int[] query(StringBuilder word) {
            Trie node = this;
            int left = -1, right = -1;
            for (int i = 0; i < word.length(); ++i) {
                int u = word.charAt(i) - 'a';
                node = node.next[u];
                if (node == null) return new int[]{-1, -1};
                left = minMap.get(node);
                right = maxMap.get(node);

            }
            return new int[]{left, right};
        }
    }
}
