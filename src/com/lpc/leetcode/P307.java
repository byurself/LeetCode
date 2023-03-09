package com.lpc.leetcode;

/**
 * 区域和检索 - 数组可修改
 *
 * @author byu_rself
 * @date 2022/9/17 15:35
 */
public class P307 {

    int[] tree;
    int[] nums;
    int n;

    private int lowbit(int x) {
        return x & -x;
    }

    private void add(int x, int val) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += val;
        }
    }

    private int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    public P307 (int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
