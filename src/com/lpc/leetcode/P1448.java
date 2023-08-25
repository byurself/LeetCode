package com.lpc.leetcode;

/**
 * 统计二叉树中好节点的数目
 *
 * @author byu_rself
 * @date 2023/8/25 14:24
 */
public class P1448 {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int left = dfs(root.left, Math.max(max, root.val));
        int right = dfs(root.right, Math.max(max, root.val));
        return left + right + (max <= root.val ? 1 : 0);
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
