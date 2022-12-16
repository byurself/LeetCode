package com.lpc.leetcode;

import org.junit.Test;

/**
 * 重排链表
 *
 * @author byu_rself
 * @date 2022/12/16 17:01
 */
public class Offer026 {

    @Test
    public void solution() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head);
    }

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        ListNode p = head, q = pre;
        while (p != null && q != null) {
            ListNode p_temp = p.next;
            ListNode q_temp = q.next;
            p.next = q;
            p = p_temp;
            q.next = p;
            q = q_temp;
        }
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
