package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树节点最小距离
 *
 * @author byu_rself
 * @date 2023/9/4 14:36
 */
public class P783 {

    TreeNode pre = null;
    int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) {
            ans = Math.min(ans, Math.abs(root.val - pre.val));
        }
        pre = root;
        dfs(root.right);
    }

    /*public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        list.sort((a, b) -> a - b);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); ++i) {
            ans = Math.min(ans, Math.abs(list.get(i - 1) - list.get(i)));
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
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
