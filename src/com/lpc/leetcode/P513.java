package com.lpc.leetcode;

import org.junit.Test;

/**
 * 找树左下角的值
 *
 * @author byu_rself
 * @date 2022/6/22 13:00
 */
public class P513 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(findBottomLeftValue(root));
    }

    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, curHeight);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
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
