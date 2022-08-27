package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树最高宽度
 *
 * @author byu_rself
 * @date 2022/8/27 17:25
 */
public class P622 {

    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(new TreeNode(1, root.left, root.right));
        while (!queue.isEmpty()) {
            int size = queue.size(), startIndex = -1, endIndex = -1;
            while (size-- > 0) {
                TreeNode p = queue.pop();
                endIndex = p.val;
                if (startIndex == -1) startIndex = p.val;
                if (p.left != null) queue.addLast(new TreeNode(p.val * 2, p.left.left, p.left.right));
                if (p.right != null) queue.addLast(new TreeNode(p.val * 2 + 1, p.right.left, p.right.right));
            }
            res = Math.max(res, endIndex - startIndex + 1);
        }
        return res;
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
