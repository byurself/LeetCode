package com.lpc.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Deque;
import java.util.List;

/**
 * 序列化和反序列化二叉搜索树
 *
 * @author byu_rself
 * @date 2022/5/11 20:40
 */
public class P449 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String s = serialize(root);
        System.out.println(s);
        System.out.println(deserialize(s));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Deque<String> queue = new LinkedList<>(List.of(data.split(",")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Deque<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    /*// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                builder.append("#").append(",");
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
        if (data.isEmpty()) return null;
        Deque<String> nodes = new LinkedList<>(List.of(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            if (!left.equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(left));
                queue.offer(cur.left);
            }
            if (!right.equals("#")) {
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
    }
}
