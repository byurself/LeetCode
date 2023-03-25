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

    List<int[]> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        list.sort((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // 列号从小到大
            else if (a[0] != b[0]) return a[0] - b[0]; // 同列节点，行号从小到大
            else return a[2] - b[2]; // 同行同列节点，按值从小到大
        });
        List<List<Integer>> ans = new ArrayList<>();
        int lastCol = Integer.MIN_VALUE, index = 0;
        for (int[] a : list) {
            int col = a[1], val = a[2];
            if (lastCol != col) {
                lastCol = col;
                ans.add(new ArrayList<>());
                ++index;
            }
            ans.get(index - 1).add(val);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;
        list.add(new int[]{row, col, node.val});
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs2(root, 0, 0, list);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                else if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[2] - o2[2];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        int lastCol = Integer.MIN_VALUE, index = 0;
        for (int[] e : list) {
            int row = e[0], column = e[1], val = e[2];
            if (lastCol != column) {
                ans.add(new ArrayList<>());
                index++;
                lastCol = column;
            }
            ans.get(index - 1).add(val);
        }

        return ans;
    }

    private void dfs2(TreeNode node, int row, int column, List<int[]> list) {
        if (node == null) return;
        list.add(new int[]{row, column, node.val});
        dfs2(node.left, row + 1, column - 1, list);
        dfs2(node.right, row + 1, column + 1, list);
    }

/*    public List<List<Integer>> verticalTraversal1(TreeNode root) {
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

    private void dfs1(TreeNode node, int row, int column, List<int[]> list) {
        if (node == null) return;
        list.add(new int[]{row, column, node.val});
        dfs(node.left, row + 1, column - 1, list);
        dfs(node.right, row + 1, column + 1, list);
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
