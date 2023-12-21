package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树最大宽度
 *
 * @author byu_rself
 * @date 2023/12/21 14:23
 */
public class P662 {

    int ans = 0;
    Map<Integer, Integer> minIndex = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }

    private void dfs(TreeNode node, int index, int depth) {
        if (node == null) return;
        minIndex.putIfAbsent(depth, index);
        ans = Math.max(ans, index - minIndex.get(depth) + 1);
        dfs(node.left, index * 2, depth + 1);
        dfs(node.right, index * 2 + 1, depth + 1);
    }

    public int widthOfBinaryTree1(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        // 将节点的索引值存入 val 中
        queue.offer(new TreeNode(1, root.left, root.right));
        while (!queue.isEmpty()) {
            int size = queue.size(), startIndex = -1, endIndex = -1;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                endIndex = node.val;
                if (startIndex == -1) startIndex = node.val;
                if (node.left != null) {
                    queue.offer(new TreeNode(node.val * 2, node.left.left, node.left.right));
                }
                if (node.right != null) {
                    queue.offer(new TreeNode(node.val * 2 + 1, node.right.left, node.right.right));
                }
            }
            ans = Math.max(ans, endIndex - startIndex + 1);
        }
        return ans;
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
