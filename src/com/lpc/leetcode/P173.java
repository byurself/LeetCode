package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉搜索树迭代器
 *
 * @author byu_rself
 * @date 2023/9/13 9:51
 */
public class P173 {

    Deque<TreeNode> stack;

    public P173(TreeNode root) {
        stack = new ArrayDeque<>();
        dfsLeft(root);
    }

    private void dfsLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode cur = stack.pop();
        int ans = cur.val;
        cur = cur.right;
        dfsLeft(cur);
        return ans;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /*List<Integer> list;
    int index;

    public P173(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
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
