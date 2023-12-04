package com.lpc.leetcode;

/**
 * 从二叉搜索树到更大和树
 *
 * @author byu_rself
 * @date 2023/12/4 9:20
 */
public class P1038 {

    int sum;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * 反序进行中序遍历：右->中->左，即单调递减
     */
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
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
