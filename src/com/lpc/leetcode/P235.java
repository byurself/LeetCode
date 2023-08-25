package com.lpc.leetcode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author byu_rself
 * @date 2023/8/25 14:33
 */
public class P235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        int a = root.val, b = Math.min(p.val, q.val), c = Math.max(p.val, q.val);
        // p 和 q 在当前节点的两侧
        if (b < a && a < c) return root;
            // p 和 q 在当前节点的右子树
        else if (a < b) return lowestCommonAncestor(root.right, p, q);
            // p 和 q 在当前节点的左子树
        else return lowestCommonAncestor(root.left, p, q);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
