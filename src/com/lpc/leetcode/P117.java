package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针II
 *
 * @author byu_rself
 * @date 2023/11/3 11:12
 */
public class P117 {

    public Node connect(Node root) {
        Node dummy = new Node(), cur = root;
        while (cur != null) {
            dummy.next = null;
            Node next = dummy; // 下一层的链表
            while (cur != null) { // 遍历当前层的链表
                if (cur.left != null) { // 将下一层的相邻节点连起来
                    next.next = cur.left;
                    next = cur.left;
                }
                if (cur.right != null) { // 将下一层的相邻节点连起来
                    next.next = cur.right;
                    next = cur.right;
                }
                cur = cur.next; // 当前层链表的下一个节点
            }
            cur = dummy.next; // 下一层链表的头节点
        }
        return root;
    }

    // DFS
    /*List<Node> pre = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int depth) {
        if (node == null) return;
        if (depth == pre.size()) {
            // node 是这一层最左边的节点
            pre.add(node);
        } else {
            pre.get(depth).next = node;
            pre.set(depth, node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }*/

    // BFS
    /*public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node p = null;
            while (size-- > 0) {
                Node cur = queue.poll();
                if (p != null) {
                    p.next = cur;
                }
                p = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }*/

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
