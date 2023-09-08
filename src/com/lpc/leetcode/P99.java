package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 恢复二叉搜索树
 *
 * @author byu_rself
 * @date 2023/9/8 9:05
 */
public class P99 {

    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pre = null;
        while (root != null) {
            if (root.left == null) {
                if (pre != null && pre.val > root.val) {
                    if (x == null) {
                        x = pre;
                    }
                    y = root;
                }
                pre = root;
                root = root.right;
            } else {
                TreeNode t = root.left;
                while (t.right != null && t.right != root) t = t.right;
                if (t.right == null) { // 若前驱节点右子树为空, 说明是真正遍历左子树前, 建立与当前根节点的链接, 然后开始真正遍历左子树
                    t.right = root;
                    root = root.left;
                } else {  // 若已存在链接, 说明是第二次访问根节点, 左子树（前驱节点）已遍历完, 此时应该解开链接, 遍历当前节点以及右子树
                    t.right = null;
                    if (pre != null && pre.val > root.val) {
                        if (x == null) {
                            x = pre;
                        }
                        y = root;
                    }
                    pre = root;
                    root = root.right;
                }
            }
        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

/*    TreeNode x = null, y = null, pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) {
            if (pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                }
            }
        }
        pre = root;
        dfs(root.right);
    }*/

/*    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode x = null, y = null;
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
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
