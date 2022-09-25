package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前缀和后缀搜索
 *
 * @author byu_rself
 * @date 2022/9/25 21:08
 */
public class P745 {

    private static class TrieNode {
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
    }
}
