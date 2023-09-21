package com.lpc.leetcode;

/**
 * 二叉树中的最大路径和
 *
 * @author byu_rself
 * @date 2023/9/21 10:25
 */
public class P124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;
        if (left >= 0) sum += left;
        if (right >= 0) sum += right;
        ans = Math.max(ans, sum);
        return Math.max(root.val, Math.max(left, right) + root.val);
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
