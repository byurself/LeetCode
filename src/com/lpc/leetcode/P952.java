package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 按公因数计算最大组件大小
 *
 * @author byu_rself
 * @date 2022/9/16 16:03
 */
public class P952 {

    @Test
    public void solution() {
        int[] nums = new int[]{20, 50, 9, 63};
        System.out.println(largestComponentSize(nums));
    }

    public int largestComponentSize(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        UnionFind unionFind = new UnionFind(max + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }

        int[] cnt = new int[max + 1];
        int ans = 0;
        for (int num : nums) {
            int root = unionFind.find(num);
            cnt[root]++;
            ans = Math.max(ans, cnt[root]);
        }
        return ans;
    }

    private static class UnionFind {
        /**
         * 节点i所指向的
         */
        private int[] parent;

        /**
         * 以i为根的集合所表示的树的层数
         */
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
