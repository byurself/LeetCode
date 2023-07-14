package com.lpc.leetcode;

/**
 * 在二叉树中分配硬币
 *
 * @author byu_rself
 * @date 2023/7/14 9:09
 */
public class P979 {

    int ans;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int d = dfs(node.left) + dfs(node.right) + node.val - 1;
        ans += Math.abs(d);
        return d;
    }

    /*int ans;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // 子树硬币个数
        int coins = left[0] + right[0] + node.val;
        // 子树节点数
        int nodes = left[1] + right[1] + 1;
        ans += Math.abs(coins - nodes);
        return new int[]{coins, nodes};
    }*/

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
