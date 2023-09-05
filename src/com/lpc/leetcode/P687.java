package com.lpc.leetcode;

/**
 * 最长同值路径
 *
 * @author byu_rself
 * @date 2022/9/2 12:24
 */
public class P687 {

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return -1; // 下面+1后，对于叶子节点就刚好为0
        int left = dfs(root.left) + 1; // 左子树最大链长+1
        int right = dfs(root.right) + 1; // 右子树最大链长+1
        if (root.left != null && root.left.val != root.val) left = 0; // 链长视为0
        if (root.right != null && root.right.val != root.val) right = 0; // 链长视为0
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
