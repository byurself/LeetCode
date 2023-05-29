package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前缀和后缀搜索
 *
 * @author byu_rself
 * @date 2022/9/25 21:08
 */
public class P745 {

    Trie trie1, trie2;

    public P745(String[] words) {
        trie1 = new Trie();
        trie2 = new Trie();
        for (int i = 0; i < words.length; ++i) {
            trie1.insert(words[i], i, false);
            trie2.insert(words[i], i, true);
        }
    }

    public int f(String pref, String suff) {
        return query(pref, suff);
    }

    private int query(String pref, String suff) {
        int n = pref.length(), m = suff.length();
        Trie node = trie1;
        for (int i = 0; i < n; ++i) {
            int u = pref.charAt(i) - 'a';
            if (node.next[u] == null) return -1;
            node = node.next[u];
        }
        List<Integer> list1 = node.idxs;
        node = trie2;
        for (int i = m - 1; i >= 0; --i) {
            int u = suff.charAt(i) - 'a';
            if (node.next[u] == null) return -1;
            node = node.next[u];
        }
        List<Integer> list2 = node.idxs;
        int i = list1.size() - 1, j = list2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) > list2.get(j)) --i;
            else if (list1.get(i) < list2.get(j)) --j;
            else return list1.get(i);
        }
        return -1;
    }

    private static class Trie {
        Trie[] next;
        List<Integer> idxs;

        public Trie() {
            next = new Trie[26];
            idxs = new ArrayList<>();
        }

        /**
         * 插入字典树
         *
         * @param word 待插入字符串
         * @param idx  字符串所在下标
         * @param flag 正向存储和反向存储的标志位
         */
        private void insert(String word, int idx, boolean flag) {
            Trie node = this;
            node.idxs.add(idx);
            int n = word.length();
            for (int i = flag ? n - 1 : 0; i >= 0 && i < n; i += flag ? -1 : 1) {
                int u = word.charAt(i) - 'a';
                if (node.next[u] == null) {
                    node.next[u] = new Trie();
                }
                node = node.next[u];
                node.idxs.add(idx);
            }
        }
    }

    // 暴力
/*    Map<String, Integer> map;

    public P745(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            int n = word.length();
            for (int pref = 1; pref <= n; ++pref) {
                for (int suff = 1; suff <= n; ++suff) {
                    map.put(word.substring(0, pref) + "_" + word.substring(n - suff), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "_" + suff, -1);
    }*/

    /*private static class TrieNode {
        List<Integer> list = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode prefix;
    private TrieNode suffix;

    public P745(String[] words) {
        prefix = new TrieNode();
        suffix = new TrieNode();
        build(prefix, words, true);
        build(suffix, words, false);
    }

    public int f(String pref, String suff) {
        List<Integer> prefList = query(prefix, pref, true);
        List<Integer> suffList = query(suffix, suff, false);
        int i = prefList.size() - 1, j = suffList.size() - 1;
        while (i >= 0 && j >= 0) {
            int l1 = prefList.get(i), l2 = suffList.get(j);
            if (l1 == l2) return l1;
            else if (l1 > l2) i--;
            else j--;
        }
        return -1;
    }

    private void build(TrieNode root, String[] words, boolean isPref) {
        for (int i = 0; i < words.length; i++) {
            TrieNode p = root;
            int len = words[i].length();
            for (int j = isPref ? 0 : len - 1; j >= 0 && j < len; j = isPref ? j + 1 : j - 1) {
                int cur = words[i].charAt(j) - 'a';
                if (p.children[cur] == null) p.children[cur] = new TrieNode();
                p = p.children[cur];
                p.list.add(i);
            }
        }
    }

    private List<Integer> query(TrieNode root, String s, boolean isPref) {
        TrieNode p = root;
        int len = s.length();
        for (int i = isPref ? 0 : len - 1; i >= 0 && i < len; i = isPref ? i + 1 : i - 1) {
            int cur = s.charAt(i) - 'a';
            if (p.children[cur] == null) return new ArrayList<>();
            p = p.children[cur];
        }
        return p.list;
    }*/
}
