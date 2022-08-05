package com.lpc.leetcode;

import org.junit.Test;

/**
 * Univalued Binary Tree
 *
 * @author byu_rself
 * @date 2022/5/24 9:14
 */
public class P965 {

    @Test
    public void solution() {

    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val != root.left.val || !isUnivalTree(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val || !isUnivalTree(root.right)) {
                return false;
            }
        }
        return true;
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
