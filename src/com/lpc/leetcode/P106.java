package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author byu_rself
 * @date 2024/2/21 9:45
 */
public class P106 {

    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int postorderLeft, int postorderRight, int inorderLeft, int inorderRight) {
        if (postorderLeft > postorderRight) return null;
        int inorderRoot = map.get(postorder[postorderRight]); // 在中序遍历中定位根节点
        TreeNode root = new TreeNode(postorder[postorderRight]);
        int leftSubTreeSize = inorderRoot - inorderLeft; // 左子树大小
        root.left = build(postorderLeft, postorderLeft + leftSubTreeSize - 1, inorderLeft, inorderRoot - 1);
        root.right = build(postorderLeft + leftSubTreeSize, postorderRight - 1, inorderRoot + 1, inorderRight);
        return root;
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
