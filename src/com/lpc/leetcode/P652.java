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

    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }

    // 序列化二叉树，如果某一个结果已经出现过一次，就发现了一类重复子树
    private String dfs(TreeNode node) {
        if (node == null) return "";
        String s = node.val +
                "(" +
                dfs(node.left) +
                ")(" +
                dfs(node.right) +
                ")";
        if (map.containsKey(s)) set.add(map.get(s));
        else map.put(s, node);
        return s;
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
