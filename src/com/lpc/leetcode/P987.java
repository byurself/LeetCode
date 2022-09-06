package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 二叉树的垂序遍历
 *
 * @author byu_rself
 * @date 2022/9/6 11:09
 */
public class P987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1]; // 列号从小到大
                else if (o1[0] != o2[0]) return o1[0] - o2[0]; // 同列节点，行号从小到大
                else return o1[2] - o2[2]; // 同行同列节点，值从小到大
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        int lastCol = Integer.MIN_VALUE, index = 0;
        for (int[] a : list) {
            int column = a[1], value = a[2];
            if (column != lastCol) {
                lastCol = column;
                ans.add(new ArrayList<>());
                index++;
            }
            ans.get(index - 1).add(value);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int column, List<int[]> list) {
        if (node == null) return;
        list.add(new int[]{row, column, node.val});
        dfs(node.left, row + 1, column - 1, list);
        dfs(node.right, row + 1, column + 1, list);
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
