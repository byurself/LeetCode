package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大二叉树
 *
 * @author byu_rself
 * @date 2022/8/20 12:20
 */
public class P654 {

    /**
     * 用数组实现单调栈
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        TreeNode[] stack = new TreeNode[nums.length];
        int index = 0;
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (index != 0 && num > stack[index - 1].val) {
                node.left = stack[--index];
            }
            if (index != 0) {
                stack[index - 1].right = node;
            }
            stack[index++] = node;
        }
        // 返回栈底的元素，也就是最大值
        return stack[0];
    }

    /**
     * 单调栈
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode p = new TreeNode(num);
            // 如果当前num值大于栈顶元素，则栈中的元素位num的左子树
            while (!stack.isEmpty() && num > stack.peek().val) {
                p.left = stack.pop();
            }
            // 如果栈中还有元素，则说明栈顶元素大于当前元素num，即num为栈顶元素的右子树
            if (!stack.isEmpty()) {
                stack.peek().right = p;
            }
            stack.push(p);
        }
        // 返回栈底元素
        return stack.peekLast();
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        TreeNode p = new TreeNode(nums[max]);
        p.left = build(nums, l, max - 1);
        p.right = build(nums, max + 1, r);
        return p;
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
