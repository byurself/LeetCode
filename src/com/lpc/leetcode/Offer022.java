package com.lpc.leetcode;

/**
 * 链表中倒数第k个节点
 *
 * @author byu_rself
 * @date 2022/8/1 10:22
 */
public class Offer022 {

    /**
     * 快慢指针
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 遍历链表，差值法
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        for(p = head; n > k; n--) {
            p = p.next;
        }
        return p;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
