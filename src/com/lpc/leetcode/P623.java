package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在二叉树中增加一行
 *
 * @author byu_rself
 * @date 2022/8/5 9:19
 */
public class P623 {
    /**
     * DFS
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

    /**
     * BFS
     */
    public TreeNode addOneRowBFS(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        int currentDepth = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode p = queue.pollFirst();
                if (depth - 1 == currentDepth) {
                    p.left = new TreeNode(val, p.left, null);
                    p.right = new TreeNode(val, null, p.right);
                } else {
                    if (p.left != null) queue.addLast(p.left);
                    if (p.right != null) queue.addLast(p.right);
                }
            }
            currentDepth++;
        }
        return root;
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
