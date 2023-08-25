package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 *
 * @author byu_rself
 * @date 2023/8/25 15:32
 */
public class P236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a = new ArrayList<>(), b = new ArrayList<>();
        dfs(root, p, a);
        dfs(root, q, b);
        TreeNode ans = null;
        for (int i = 0; i < Math.min(a.size(), b.size()) && a.get(i) == b.get(i); ++i) {
            ans = a.get(i);
        }
        return ans;
    }

    private boolean dfs(TreeNode cur, TreeNode target, List<TreeNode> path) {
        if (cur == null) return false;
        path.add(cur);
        if (cur == target || dfs(cur.left, target, path) || dfs(cur.right, target, path)) {
            return true;
        } else {
            path.remove(path.size() - 1);
            return false;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
