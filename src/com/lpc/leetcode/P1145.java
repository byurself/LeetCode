package com.lpc.leetcode;

/**
 * 二叉树着色游戏
 *
 * @author byu_rself
 * @date 2023/2/3 13:49
 */
public class P1145 {

    private int leftSize, rightSize;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        return Math.max(Math.max(leftSize, rightSize), n - 1 - leftSize - rightSize) * 2 > n;
    }

    private int dfs(TreeNode node, int x) {
        if (node == null) return 0;
        int ls = dfs(node.left, x);
        int rs = dfs(node.right, x);
        if (node.val == x) {
            leftSize = ls;
            rightSize = rs;
        }
        return ls + rs + 1;
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
