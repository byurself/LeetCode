package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author byu_rself
 * @date 2024/2/20 9:27
 */
public class P105 {

    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) return null;
        int inorderRoot = map.get(preorder[preorderLeft]); // 在中序遍历中定位根节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int leftSubTreeSize = inorderRoot - inorderLeft; // 左子树数目
        root.left = build(preorderLeft + 1, preorderLeft + leftSubTreeSize, inorderLeft, inorderRoot - 1);
        root.right = build(preorderLeft + leftSubTreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);
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
