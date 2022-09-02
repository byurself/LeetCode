package com.lpc.leetcode;

/**
 * 最长同值路径
 *
 * @author byu_rself
 * @date 2022/9/2 12:24
 */
public class P687 {

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        int l = 0, r = 0;
        if (root.left != null && root.left.val == root.val) l = left + 1;
        if (root.right != null && root.right.val == root.val) r = right + 1;
        res = Math.max(res, l + r); // 更新最长同值路径
        return Math.max(l, r); // 返回结点对应的最长同值路径
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
