package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * @author byu_rself
 * @date 2023/7/13 9:13
 */
public class Offer034 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        target -= root.val;
        path.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);
    }

    /*List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum += root.val;
        path.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.remove(path.size() - 1);
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
