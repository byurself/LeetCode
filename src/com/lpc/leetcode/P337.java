package com.lpc.leetcode;

/**
 * 打家劫舍III
 *
 * @author byu_rself
 * @date 2023/9/18 9:26
 */
public class P337 {

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    /**
     * 返回二元组 [a,b]，其中 a 表示偷取 root 节点时的最大金额， b 表示不偷取 root 节点时的最大金额
     */
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{root.val + left[1] + right[1], // 1.偷取 root 节点，那么不能偷取左右子节点
                Math.max(left[0], left[1]) + Math.max(right[0], right[1])}; // 2.不偷取 root 节点，那么可以偷取左右子节点
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
