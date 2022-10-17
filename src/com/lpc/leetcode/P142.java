package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * @author byu_rself
 * @date 2022/10/8 16:45
 */
public class P142 {

    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while (p != null) {
            if (set.contains(p)) return p;
            else set.add(p);
            p = p.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
