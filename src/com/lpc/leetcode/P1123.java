package com.lpc.leetcode;

/**
 * 最深叶节点的最近公共祖先
 *
 * @author byu_rself
 * @date 2023/9/6 9:56
 */
public class P1123 {

    TreeNode ans;
    int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int leftMaxDepth = dfs(node.left, depth + 1);
        int rightMaxDepth = dfs(node.right, depth + 1);
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth) {
            ans = node;
        }
        return Math.max(leftMaxDepth, rightMaxDepth); // 返回当前子树的最大深度
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
