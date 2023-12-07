package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树
 *
 * @author byu_rself
 * @date 2022/8/22 13:26
 */
public class P655 {

    List<List<String>> ans;
    int height;

    public List<List<String>> printTree(TreeNode root) {
        getHeight(root, 0);
        int m = height + 1, n = (1 << height + 1) - 1;
        ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                list.add("");
            }
            ans.add(list);
        }
        dfs(root, 0, (n - 1) >> 1);
        return ans;
    }

    private void dfs(TreeNode root, int r, int c) {
        if (root == null) return;
        ans.get(r).set(c, String.valueOf(root.val));
        dfs(root.left, r + 1, c - (1 << height - r - 1));
        dfs(root.right, r + 1, c + (1 << height - r - 1));
    }

    private void getHeight(TreeNode root, int depth) {
        if (root == null) return;
        height = Math.max(height, depth);
        getHeight(root.left, depth + 1);
        getHeight(root.right, depth + 1);
    }


    /*int height = 0;
    List<List<String>> ans;

    public List<List<String>> printTree(TreeNode root) {
        getHeight(root, 0);
        int m = height + 1, n = (1 << (height + 1)) - 1;
        ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            ans.add(list);
        }
        dfs(root, 0, (n - 1) / 2);
        return ans;
    }

    private void dfs(TreeNode root, int r, int c) {
        if (root == null) return;
        ans.get(r).set(c, String.valueOf(root.val));
        dfs(root.left, r + 1, c - (1 << height - r - 1));
        dfs(root.right, r + 1, c + (1 << height - r - 1));
    }

    private void getHeight(TreeNode root, int depth) {
        if (root == null) return;
        height = Math.max(height, depth);
        getHeight(root.left, depth + 1);
        getHeight(root.right, depth + 1);
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
