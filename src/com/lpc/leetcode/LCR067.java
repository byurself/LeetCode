package com.lpc.leetcode;

/**
 * 数组中两个数的最大异或值
 *
 * @author byu_rself
 * @date 2023/8/7 14:43
 */
public class LCR067 {

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        Trie trie = new Trie();
        for (int num : nums) {
            trie.add(num);
            int x = trie.getVal(num);
            ans = Math.max(ans, num ^ x);
        }
        return ans;
    }

    private static class Trie {
        Trie[] node = new Trie[2];

        public void add(int x) {
            Trie trie = this;
            for (int i = 31; i >= 0; --i) {
                int u = (x >> i) & 1;
                if (trie.node[u] == null) {
                    trie.node[u] = new Trie();
                }
                trie = trie.node[u];
            }
        }

        public int getVal(int x) {
            Trie trie = this;
            int ans = 0;
            for (int i = 31; i >= 0; --i) {
                int a = (x >> i) & 1, b = 1 - a;
                if (trie.node[b] != null) {
                    ans |= (b << i);
                    trie = trie.node[b];
                } else {
                    ans |= (a << i);
                    trie = trie.node[a];
                }
            }
            return ans;
        }
    }
}
