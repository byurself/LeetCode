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
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1; // 该节点为根的子树的深度
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
