package com.lpc.leetcode;

/**
 * 单值二叉树
 *
 * @author byu_rself
 * @date 2022/5/24 9:14
 */
public class P965 {

    int val = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (val == -1) val = root.val;
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
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
