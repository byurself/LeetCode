package com.lpc.leetcode;

/**
 * 有序链表转换二叉搜索树
 *
 * @author byu_rself
 * @date 2023/9/11 11:10
 */
public class P109 {

    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            ++n;
        }
        return build(0, n - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int mid = left + right >> 1;
        TreeNode node = new TreeNode();
        node.left = build(left, mid - 1);
        node.val = head.val;
        head = head.next;
        node.right = build(mid + 1, right);
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
