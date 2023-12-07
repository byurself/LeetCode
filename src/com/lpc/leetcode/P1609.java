package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 奇偶树
 *
 * @author byu_rself
 * @date 2023/12/7 11:08
 */
public class P1609 {

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (depth % 2 == 0) {
                    if (cur.val % 2 == 0) return false;
                    if (!list.isEmpty() && list.get(list.size() - 1) >= cur.val) return false;
                } else {
                    if (cur.val % 2 == 1) return false;
                    if (!list.isEmpty() && list.get(list.size() - 1) <= cur.val) return false;
                }
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ++depth;
        }
        return true;
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
