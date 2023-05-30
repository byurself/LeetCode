package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中两个数的最大异或值
 *
 * @author byu_rself
 * @date 2023/2/21 11:04
 */
public class P421 {

    @Test
    public void solution() {
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int ans = 0;
        for (int x : nums) {
            trie.insert(x);
            int y = trie.getVal(x);
            ans = Math.max(ans, x ^ y);
        }
        return ans;
    }

    private static class Trie {
        Trie[] next;

        public Trie() {
            next = new Trie[2];
        }

        public void insert(int x) {
            Trie node = this;
            for (int i = 31; i >= 0; --i) {
                int u = (x >> i) & 1;
                if (node.next[u] == null) {
                    node.next[u] = new Trie();
                }
                node = node.next[u];
            }
        }

        public int getVal(int x) {
            Trie node = this;
            int ans = 0;
            for (int i = 31; i >= 0; --i) {
                int a = (x >> i) & 1, b = 1 - a;
                if (node.next[b] != null) {
                    ans |= (b << i);
                    node = node.next[b];
                } else {
                    ans |= (a << i);
                    node = node.next[a];
                }
            }
            return ans;
        }
    }

    // 利用性质： a ^ b = c ，则 a ^ c = b，且 b ^ c = a
    public int findMaximumXOR1(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
