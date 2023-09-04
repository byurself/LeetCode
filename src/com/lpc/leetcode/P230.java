package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 二叉搜索树中第K小的元素
 *
 * @author byu_rself
 * @date 2023/9/4 14:18
 */
public class P230 {

    int ans, k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (k == 0) return;
        if (--k == 0) ans = root.val;
        inOrder(root.right);
    }

/*    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        preOrder(root, q);
        while (--k > 0) q.poll();
        return q.peek();
    }

    private void preOrder(TreeNode root, PriorityQueue<Integer> q) {
        if (root == null) return;
        q.offer(root.val);
        preOrder(root.left, q);
        preOrder(root.right, q);
    }*/

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
