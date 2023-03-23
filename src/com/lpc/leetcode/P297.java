package com.lpc.leetcode;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 *
 * @author byu_rself
 * @date 2023/3/23 16:56
 */
public class P297 {

    private static final String EMPTY = "NULL";

    // DFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return EMPTY + ",";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals(EMPTY)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }

    // BFS
    /*// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) builder.append(EMPTY + ",");
            else {
                builder.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] split = data.split(",");
        Queue<String> nodes = new LinkedList<>(Arrays.asList(split));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            if (!left.equals(EMPTY)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            if (!right.equals(EMPTY)) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }
        }
        return root;
    }*/

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
