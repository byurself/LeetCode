package com.lpc.leetcode;

import java.util.*;

/**
 * 二叉树中的第K大层和
 *
 * @author byu_rself
 * @date 2024/2/23 10:53
 */
public class P2583 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Long> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            long sum = 0;
            for (int size = queue.size(); size > 0; --size) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(sum);
        }
        int n = list.size();
        if (n < k) return -1;
        Collections.sort(list);
        return list.get(n - k);
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
