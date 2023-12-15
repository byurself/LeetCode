package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 反转二叉树的奇数层
 *
 * @author byu_rself
 * @date 2023/12/15 9:58
 */
public class P2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (flag) list.add(node);
                // 树为满二叉树
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (flag) {
                for (int left = 0, right = list.size() - 1; left < right; ++left, --right) {
                    int temp = list.get(left).val;
                    list.get(left).val = list.get(right).val;
                    list.get(right).val = temp;
                }
            }
            flag = !flag;
        }
        return root;
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
