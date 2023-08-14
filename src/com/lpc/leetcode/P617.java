package com.lpc.leetcode;

/**
 * 合并二叉树
 *
 * @author byu_rself
 * @date 2023/8/14 9:35
 */
public class P617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root2 == null) return root1;
        if (root1 == null) return root2;
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
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
