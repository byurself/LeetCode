package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author byu_rself
 * @date 2022/5/1 13:56
 */
public class P94 {

    @Test
    public void solution() {
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        List<Integer> list = inorderTraversal(root1);
        list.forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
