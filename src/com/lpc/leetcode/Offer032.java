package com.lpc.leetcode;

import java.util.*;

/**
 * 从上到下打印二叉树
 *
 * @author byu_rself
 * @date 2022/8/5 8:27
 */
public class Offer032 {

    public int[] levelOrderI(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.pollFirst();
            list.add(p.val);
            if (p.left != null) queue.addLast(p.left);
            if (p.right != null) queue.addLast(p.right);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode p = queue.pollFirst();
                list.add(p.val);
                if (p.left != null) queue.addLast(p.left);
                if (p.right != null) queue.addLast(p.right);
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size(), level = ans.size();
            while (size-- > 0) {
                TreeNode p = queue.pollFirst();
                if (level % 2 == 0) list.addLast(p.val);
                else list.addFirst(p.val);
                if (p.left != null) queue.addLast(p.left);
                if (p.right != null) queue.addLast(p.right);
            }
            ans.add(list);
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
