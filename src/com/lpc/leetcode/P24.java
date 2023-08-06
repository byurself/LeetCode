package com.lpc.leetcode;

/**
 * 两两交换链表中的节点
 *
 * @author byu_rself
 * @date 2023/8/6 9:52
 */
public class P24 {

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ans = new ListNode(0, head);
        ListNode pre = ans, cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            pre.next = temp;
            pre = cur;
            cur = cur.next;
        }
        return ans.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
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
