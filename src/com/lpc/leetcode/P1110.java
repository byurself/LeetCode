package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删点成林
 *
 * @author byu_rself
 * @date 2023/5/30 9:05
 */
public class P1110 {

    List<TreeNode> ans = new ArrayList<>();
    boolean[] s = new boolean[1001];

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x : to_delete) s[x] = true;
        if (dfs(root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        if (!s[node.val]) return node;
        if (node.left != null) ans.add(node.left);
        if (node.right != null) ans.add(node.right);
        return null;
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
