package com.lpc.leetcode;

/**
 * 二叉树的直径
 *
 * @author byu_rself
 * @date 2023/3/12 15:30
 */
public class P543 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return -1; // 下面+1后，对于叶子节点就刚好为0
        int left = dfs(root.left) + 1; // 左子树最大链长+1
        int right = dfs(root.right) + 1; // 右子树最大链长+1
        ans = Math.max(ans, left + right);
        return Math.max(left, right); // 当前子树最大链长
    }

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
