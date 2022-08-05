package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 两棵二叉搜索树中的所有元素
 *
 * @author byu_rself
 * @date 2022/5/1 13:48
 */
public class P1305 {

    @Test
    public void solution() {
        // TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        // TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
        TreeNode root1 = new TreeNode(1, new TreeNode(), new TreeNode(8));
        TreeNode root2 = new TreeNode(8, new TreeNode(1), new TreeNode());
        List<Integer> list = getAllElements(root1, root2);
        list.forEach(System.out::println);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        dfs(root1, list);
        dfs(root2, list);
        Collections.sort(list);
        return list;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param list
     */
    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
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
