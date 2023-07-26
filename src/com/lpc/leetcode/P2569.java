package com.lpc.leetcode;

/**
 * 更新数组后处理求和查询
 *
 * @author byu_rself
 * @date 2023/7/26 9:03
 */
public class P2569 {

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        SegmentTree tree = new SegmentTree(nums1);
        long s = 0;
        for (int x : nums2) s += x;
        int m = 0;
        for (int[] query : queries) {
            if (query[0] == 3) ++m;
        }
        long[] ans = new long[m];
        int i = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                tree.modify(1, query[1] + 1, query[2] + 1);
            } else if (query[0] == 2) {
                s += (long) query[1] * tree.query(1, 1, nums2.length);
            } else {
                ans[i++] = s;
            }
        }
        return ans;
    }

    private static class SegmentTree {
        private final Node[] tree;
        private final int[] nums;

        public SegmentTree(int[] nums) {
            int n = nums.length;
            this.nums = nums;
            tree = new Node[n << 2];
            for (int i = 0; i < tree.length; ++i) {
                tree[i] = new Node();
            }
            build(1, 1, n);
        }

        // 建立线段树
        private void build(int u, int l, int r) {
            tree[u].l = l;
            tree[u].r = r;
            if (l == r) {
                tree[u].s = nums[l - 1];
                return;
            }
            int mid = (l + r) >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }

        // 修改区间和
        public void modify(int u, int l, int r) {
            if (tree[u].l >= l && tree[u].r <= r) {
                tree[u].lazy ^= 1;
                tree[u].s = tree[u].r - tree[u].l + 1 - tree[u].s;
                return;
            }
            pushDown(u);
            int mid = (tree[u].l + tree[u].r) >> 1;
            if (l <= mid) {
                modify(u << 1, l, r);
            }
            if (r > mid) {
                modify(u << 1 | 1, l, r);
            }
            pushUp(u);
        }

        // 查询区间和
        public int query(int u, int l, int r) {
            if (tree[u].l >= l && tree[u].r <= r) {
                return tree[u].s;
            }
            pushDown(u);
            int mid = (tree[u].l + tree[u].r) >> 1;
            int ans = 0;
            if (l <= mid) {
                ans += query(u << 1, l, r);
            }
            if (r > mid) {
                ans += query(u << 1 | 1, l, r);
            }
            return ans;
        }

        // 用子节点的信息更新父节点的信息
        private void pushUp(int u) {
            tree[u].s = tree[u << 1].s + tree[u << 1 | 1].s;
        }

        // 下传懒标记
        private void pushDown(int u) {
            if (tree[u].lazy == 1) {
                int mid = (tree[u].l + tree[u].r) >> 1;
                tree[u << 1].s = mid - tree[u].l + 1 - tree[u << 1].s;
                tree[u << 1].lazy ^= 1;
                tree[u << 1 | 1].s = tree[u].r - mid - tree[u << 1 | 1].s;
                tree[u << 1 | 1].lazy ^= 1;
                tree[u].lazy ^= 1;
            }
        }
    }

    private static class Node {
        int l, r;
        int s, lazy;
    }
}