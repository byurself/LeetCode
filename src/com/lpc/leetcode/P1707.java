package com.lpc.leetcode;

/**
 * 与数组中元素的最大异或值
 *
 * @author byu_rself
 * @date 2022/9/29 0:24
 */
public class P1707 {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for (int val : nums) trie.insert(val);
        int length = queries.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
        }
        return ans;
    }

    private static class Trie {
        private static final int mask = 30;
        Trie[] next;
        int min = Integer.MAX_VALUE;

        public Trie() {
            next = new Trie[2];
        }

        public void insert(int val) {
            Trie node = this;
            node.min = Math.min(node.min, val);
            for (int i = mask - 1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (node.next[bit] == null) {
                    node.next[bit] = new Trie();
                }
                node = node.next[bit];
                node.min = Math.min(node.min, val);
            }
        }

        public int getMaxXorWithLimit(int val, int limit) {
            Trie node = this;
            if (node.min > limit) {
                return -1;
            }
            int ans = 0;
            for (int i = mask - 1; i >= 0; --i) {
                int bit = (val >> i) & 1;
                if (node.next[bit ^ 1] != null && node.next[bit ^ 1].min <= limit) {
                    ans |= 1 << i;
                    bit ^= 1;
                }
                node = node.next[bit];
            }
            return ans;
        }
    }
}
