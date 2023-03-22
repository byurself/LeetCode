package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

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

    int[] p;
    int[] size;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        size[px] += size[py];
        p[py] = p[px];
    }

    public int largestComponentSize(int[] nums) {
        int n = nums.length, ans = 1;
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            for (int j = 2; j * j <= num; ++j) {
                if (num % j == 0) {
                    List<Integer> list = map.getOrDefault(j, new ArrayList<>());
                    list.add(i);
                    map.put(j, list);
                }
                while (num % j == 0) num /= j;
            }
            if (num > 1) {
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                list.add(i);
                map.put(num, list);
            }
        }
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 1; i < list.size(); ++i) {
                union(list.get(0), list.get(i));
                ans = Math.max(ans, size[find(list.get(0))]);
            }
        }
        return ans;
    }

    public int largestComponentSize1(int[] nums) {
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
