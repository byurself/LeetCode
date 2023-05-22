package com.lpc.leetcode;

/**
 * 根到叶路径上的不足节点
 *
 * @author byu_rself
 * @date 2023/5/22 10:43
 */
public class P1080 {

    public TreeNode sufficientSubset(TreeNode node, int limit) {
        if (node == null) return null;
        limit -= node.val;
        // 当前节点为叶子节点
        if (node.left == null && node.right == null) {
            // 如果limit > 0，说明该路径节点的值的和小于limit，需要删除
            return limit > 0 ? null : node;
        }
        node.left = sufficientSubset(node.left, limit);
        node.right = sufficientSubset(node.right, limit);
        // 如果node的左右节点经过递归调用后变成了空节点，说明经过node的所有子节点的路径和都小于limit，需要删除
        return node.left == null && node.right == null ? null : node;
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
