package com.lpc.leetcode;

/**
 * 两数相加
 *
 * @author byu_rself
 * @date 2023/7/2 18:00
 */
public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    private ListNode dfs(ListNode l1, ListNode l2, int c) {
        if (l1 == null && l2 == null) {
            // 如果进位了，就额外创建一个节点
            return c != 0 ? new ListNode(c) : null;
        }
        if (l1 == null) {
            l1 = l2;
            l2 = null;
        }
        c += l1.val + (l2 != null ? l2.val : 0);
        l1.val = c % 10;
        l1.next = dfs(l1.next, (l2 != null ? l2.next : null), c / 10);
        return l1;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), tail = head;
        int c = 0; // 进位
        while (l1 != null || l2 != null) {
            if (l1 != null) c += l1.val;
            if (l2 != null) c += l2.val;
            tail.next = new ListNode(c % 10);
            tail = tail.next;
            c /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (c > 0) {
            tail.next = new ListNode(c);
        }
        return head;
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
}
