package com.lpc.leetcode;

import java.util.*;

/**
 * 两数之和IV-输入二叉搜索树
 *
 * @author byu_rself
 * @date 2023/9/18 9:50
 */
public class P653 {

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> leftStack = new ArrayDeque<>(), rightStack = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null) {
            leftStack.push(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            rightStack.push(temp);
            temp = temp.right;
        }
        TreeNode left = leftStack.peek(), right = rightStack.peek();
        while (left.val < right.val) {
            int sum = left.val + right.val;
            if (sum < k) left = getNext(leftStack, true);
            else if (sum > k) right = getNext(rightStack, false);
            else return true;
        }
        return false;
    }

    private TreeNode getNext(Deque<TreeNode> stack, boolean isLeft) {
        TreeNode node = isLeft ? stack.pop().right : stack.pop().left;
        while (node != null) {
            stack.push(node);
            node = isLeft ? node.left : node.right;
        }
        return stack.peek();
    }


    /*public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum > k) --right;
            else if (sum < k) ++left;
            else return true;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }*/

    /*Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
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
