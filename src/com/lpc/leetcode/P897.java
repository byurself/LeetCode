package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 递增顺序搜索树
 *
 * @author byu_rself
 * @date 2023/9/7 16:07
 */
public class P897 {

    public TreeNode increasingBST1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root);
            root = root.right;
        }
        TreeNode ans = new TreeNode(-1), p = ans;
        for (TreeNode node : list) {
            p.right = node;
            node.left = null;
            p = node;
        }
        return ans.right;
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode ans = new TreeNode(-1), p = ans;
        for (TreeNode node : list) {
            p.right = node;
            p = node;
        }
        return ans.right;
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(new TreeNode(root.val));
        inOrder(root.right, list);
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
