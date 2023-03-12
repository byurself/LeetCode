package com.lpc.leetcode;

/**
 * 二叉树的最大深度
 *
 * @author byu_rself
 * @date 2023/3/12 13:22
 */
public class P104 {

    private int ans;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null) return;
        ++cnt;
        ans = Math.max(ans, cnt);
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }

    // public int maxDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     int lDepth = maxDepth(root.left);
    //     int rDepth = maxDepth(root.right);
    //     return Math.max(lDepth, rDepth) + 1;
    // }

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
