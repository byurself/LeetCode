package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 *
 * @author byu_rself
 * @date 2022/6/24 13:36
 */
public class P515 {

    @Test
    public void solution() {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        List<Integer> list = largestValues(root);
        list.forEach(System.out::println);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, 0);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root, int curHeight) {
        if (curHeight == res.size()) {
            res.add(root.val);
        } else {
            res.set(curHeight, Math.max(res.get(curHeight), root.val));
        }
        if (root.left != null) {
            dfs(res, root.left, curHeight + 1);
        }
        if (root.right != null) {
            dfs(res, root.right, curHeight + 1);
        }
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
