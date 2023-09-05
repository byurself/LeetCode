package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从根到叶的二进制数之和
 *
 * @author byu_rself
 * @date 2022/5/30 18:10
 */
public class P1022 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println(sumRootToLeaf(root));
    }

    public int sumRootToLeaf(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                cur.left.val = (cur.val << 1) + cur.left.val;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                cur.right.val = (cur.val << 1) + cur.right.val;
                queue.offer(cur.right);
            }
            if (cur.left == null && cur.right == null) {
                ans += cur.val;
            }
        }
        return ans;
    }

    /*public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int x) {
        if (root == null) return 0;
        x = (x << 1) + root.val;
        if (root.left == null && root.right == null) {
            return x;
        }
        int left = dfs(root.left, x);
        int right = dfs(root.right, x);
        return left + right;
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
