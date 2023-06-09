package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和 III
 * @author byu_rself
 * @date 2023/6/9 9:25
 */
public class P437 {

    int ans, target;
    Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        this.target = targetSum;
        map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, root.val);
        return ans;
    }

    private void dfs(TreeNode node, long val) {
        if (map.containsKey(val - target)) ans += map.get(val - target);
        map.merge(val, 1, Integer::sum);
        if (node.left != null) dfs(node.left, node.left.val + val);
        if (node.right != null) dfs(node.right, node.right.val + val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }

    // DFS
    /*int ans, target;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        dfs1(root);
        return ans;
    }

    private void dfs1(TreeNode node) {
        if (node == null) return;
        dfs2(node, node.val);
        dfs1(node.left);
        dfs1(node.right);
    }

    private void dfs2(TreeNode node, long val) {
        if (val == target) ++ans;
        if (node.left != null) dfs2(node.left, node.left.val + val);
        if (node.right != null) dfs2(node.right, node.right.val + val);
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
