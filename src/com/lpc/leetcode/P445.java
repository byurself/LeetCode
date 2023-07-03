package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 两数相加II
 *
 * @author byu_rself
 * @date 2023/7/3 9:16
 */
public class P445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode l3 = addTwo(l1, l2);
        return reverse(l3);
    }

    private ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), tail = head;
        int c = 0;
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
        return head.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode head = reverse(cur.next, cur);
        cur.next = pre;
        return head;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode();
        int c = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) c += s1.pop();
            if (!s2.isEmpty()) c += s2.pop();
            head.next = new ListNode(c % 10, head.next);
            c /= 10;
        }
        if (c > 0) {
            head.next = new ListNode(c, head.next);
        }
        return head.next;
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
