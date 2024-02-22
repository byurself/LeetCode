package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和后序遍历构造二叉树
 *
 * @author byu_rself
 * @date 2024/2/22 10:58
 */
public class P889 {

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        int n = preorder.length;
        for (int i = 0; i < n; ++i) {
            map.put(postorder[i], i);
        }
        return dfs(0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int preorderLeft, int preorderRight, int postorderLeft, int postorderRight) {
        if (preorderLeft > preorderRight) return null;
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        if (preorderLeft == preorderRight) return root; // 叶子节点
        int postorderRoot = map.get(preorder[preorderLeft + 1]); // 左子树的根节点在后序遍历中的位置
        int leftSubTreeSize = postorderRoot - postorderLeft + 1;
        root.left = dfs(preorderLeft + 1, preorderLeft + leftSubTreeSize, postorderLeft, postorderRoot);
        root.right = dfs(preorderLeft + leftSubTreeSize + 1, preorderRight, postorderRoot + 1, postorderRight - 1);
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
