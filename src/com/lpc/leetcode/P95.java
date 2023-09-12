package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树II
 *
 * @author byu_rself
 * @date 2023/6/28 10:30
 */
public class P95 {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();
        if (left > right) {
            ans.add(null);
            return ans;
        }
        for (int i = left; i <= right; ++i) {
            for (TreeNode x : dfs(left, i - 1)) {
                for (TreeNode y : dfs(i + 1, right)) {
                    TreeNode node = new TreeNode(i);
                    node.left = x;
                    node.right = y;
                    ans.add(node);
                }
            }
        }
        return ans;
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
