package com.lpc.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化二叉树
 *
 * @author byu_rself
 * @date 2023/6/7 9:52
 */
public class Offer037 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String s = serialize(root);
        TreeNode node = deserialize(s);
    }

    private static final String EMPTY = "null";

    // DFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return EMPTY + ",";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Deque<String> queue = new LinkedList<>(List.of(nodes));
        return buildTree(queue);
    }

    public TreeNode buildTree(Deque<String> queue) {
        String cur = queue.poll();
        if (cur.equals(EMPTY)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }

    // BFS
    /*private static final String EMPTY = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                builder.append(EMPTY).append(",");
            } else {
                builder.append(cur.val).append(",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] split = data.split(",");
        Deque<String> nodes = new LinkedList<>(List.of(split));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            if (!left.equals(EMPTY)) {
                cur.left = new TreeNode(Integer.parseInt(left));
                queue.offer(cur.left);
            }
            if (!right.equals(EMPTY)) {
                cur.right = new TreeNode(Integer.parseInt(right));
                queue.offer(cur.right);
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

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
}
