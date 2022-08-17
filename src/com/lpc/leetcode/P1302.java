package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 层数最深叶子节点的和
 *
 * @author byu_rself
 * @date 2022/8/17 11:15
 */
public class P1302 {


    /**
     * BFS
     */
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = 0;
            while (size-- > 0) {
                TreeNode p = queue.pollFirst();
                res += p.val;
                if (p.left != null) queue.addLast(p.left);
                if (p.right != null) queue.addLast(p.right);
            }
        }
        return res;
    }


    /**
     * DFS
     */
    int maxLevel = -1;
    int sum = 0;

    public int deepestLeavesSum2(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            sum = node.val;
        } else if (level == maxLevel) {
            sum += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }


    /**
     * BFS + hsahMap
     */
    public int deepestLeavesSum1(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.addLast(root);
        Map<Integer, Integer> map = new HashMap<>();
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode p = queue.pollFirst();
                map.put(depth, map.getOrDefault(depth, 0) + p.val);
                if (p.left != null) queue.addLast(p.left);
                if (p.right != null) queue.addLast(p.right);
            }
            depth++;
        }
        return map.get(depth - 1);
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
