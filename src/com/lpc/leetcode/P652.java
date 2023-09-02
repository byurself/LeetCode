package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 寻找重复的子树
 *
 * @author byu_rself
 * @date 2022/9/5 0:03
 */
public class P652 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        System.out.println(dfs(root));
    }

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 序列化二叉树，如果某一个结果已经出现过一次，就发现了一类重复子树
    private String dfs(TreeNode node) {
        if (node == null) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(node.val).append("_");
        builder.append(dfs(node.left)).append(dfs(node.right));
        String key = builder.toString();
        map.merge(key, 1, Integer::sum);
        if (map.get(key) == 2) ans.add(node);
        return key;
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
