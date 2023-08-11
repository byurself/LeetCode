package com.lpc.leetcode;

import org.junit.Test;

/**
 * 删除链表的倒数第N个结点
 *
 * @author byu_rself
 * @date 2023/8/11 9:53
 */
public class LCR021 {

    @Test
    public void solution() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        System.out.println(removeNthFromEnd(head, n));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), slow = dummy, fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        p = dummy;
        for (int i = 0; i < length - n; ++i) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
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
