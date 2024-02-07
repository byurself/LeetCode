package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的堂兄弟节点II
 *
 * @author byu_rself
 * @date 2024/2/7 9:47
 */
public class P2641 {

    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 统计每一层的节点和
            int sum = 0;
            for (TreeNode node : queue) {
                if (node.left != null) {
                    sum += node.left.val;
                }
                if (node.right != null) {
                    sum += node.right.val;
                }
            }
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                int sub = (node.left == null ? 0 : node.left.val) +
                        (node.right == null ? 0 : node.right.val);
                if (node.left != null) {
                    node.left.val = sum - sub;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = sum - sub;
                    queue.offer(node.right);
                }
            }
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
