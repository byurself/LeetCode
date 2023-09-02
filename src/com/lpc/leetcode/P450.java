package com.lpc.leetcode;

/**
 * 删除二叉搜索树中的节点
 *
 * @author byu_rself
 * @date 2022/6/2 21:32
 */
public class P450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 寻找当前节点的右子树中的最小值
            TreeNode t = root.right;
            while (t.left != null) t = t.left;
            // 将当前节点的左子树直接作为 t 的左子树
            t.left = root.left;
            return root.right;
        }
        return root;
    }

    /*public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 寻找当前节点的左子树中的最大值
            TreeNode t = root.left;
            while (t.right != null) t = t.right;
            // 将当前节点的右子树直接作为 t 的右子树
            t.right = root.right;
            return root.left;
        }
        return root;
    }*/

    /*public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
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
