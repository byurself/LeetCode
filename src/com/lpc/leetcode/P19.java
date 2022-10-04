package com.lpc.leetcode;

import org.junit.Test;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author byu_rself
 * @date 2022/10/5 0:39
 */
public class P19 {

    @Test
    public void solution() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode fast = head, slow = temp;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = new ListNode(0, head), p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        p = temp;
        for (int i = 0; i < length - n; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return temp.next;
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
