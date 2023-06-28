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

    private List<TreeNode> dfs(int l, int r) {
        if (l > r) return new ArrayList<>() {{
            add(null);
        }};
        List<TreeNode> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            for (TreeNode x : dfs(l, i - 1)) {
                for (TreeNode y : dfs(i + 1, r)) {
                    TreeNode root = new TreeNode(i);
                    root.left = x;
                    root.right = y;
                    ans.add(root);
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
