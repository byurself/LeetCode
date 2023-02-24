package com.lpc.leetcode;

/**
 * 情侣牵手
 *
 * @author byu_rself
 * @date 2023/2/24 11:06
 */
public class P765 {

    public int minSwapsCouples(int[] row) {
        int n = row.length, ans = 0;
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) cache[row[i]] = i;
        for (int i = 0; i < n - 1; i += 2) {
            int a = row[i], b = a ^ 1;
            if (row[i + 1] != b) {
                int src = i + 1, tar = cache[b];
                cache[row[tar]] = src;
                cache[row[src]] = tar;
                swap(row, src, tar);
                ans++;
            }
        }
        return ans;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public int minSwapsCouples1(int[] row) {
        int length = row.length;
        int n = length / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < length; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionFind.getCount();
    }

    private static class UnionFind {
        private int[] parent;
        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            count--;
        }
    }
}
