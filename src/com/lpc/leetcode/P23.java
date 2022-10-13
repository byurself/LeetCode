package com.lpc.leetcode;

/**
 * 合并K个升序链表
 *
 * @author byu_rself
 * @date 2022/10/13 12:22
 */
public class P23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        else if (l > r) return null;
        int mid = l + r >> 1;
        ListNode p1 = merge(lists, l, mid);
        ListNode p2 = merge(lists, mid + 1, r);
        return mergeTwoList(p1, p2);
    }

    private ListNode mergeTwoList(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        else if (p2 == null) return p1;
        if (p1.val < p2.val) {
            p1.next = mergeTwoList(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoList(p1, p2.next);
            return p2;
        }
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoList(ans, list);
        }
        return ans;
    }

    /*private ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null) return b;
        else if (b == null) return a;

        ListNode head = new ListNode(0);
        ListNode p = head, pa = a, pb = b;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                p.next = pa;
                pa = pa.next;
            } else {
                p.next = pb;
                pb = pb.next;
            }
            p = p.next;
        }
        p.next = pa == null ? pb : pa;
        return head.next;
    }*/

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
