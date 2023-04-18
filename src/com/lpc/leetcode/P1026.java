package com.lpc.leetcode;

/**
 * 节点与其祖先之间的最大差值
 *
 * @author byu_rself
 * @date 2023/4/18 8:17
 */
public class P1026 {

    int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int max, int min) {
        if (node == null) return;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        dfs(node.left, max, min);
        dfs(node.right, max, min);
        ans = Math.max(ans, max - min);
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
