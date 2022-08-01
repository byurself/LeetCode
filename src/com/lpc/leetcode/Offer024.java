package com.lpc.leetcode;

import org.junit.Test;

/**
 * 反转链表
 *
 * @author byu_rself
 * @date 2022/8/1 9:16
 */
public class Offer024 {

    @Test
    public void solution() {
        ListNode head = new ListNode(0), tail = head;
        int x = 1;
        while (x <= 5) {
            ListNode cur = new ListNode(x);
            tail.next = cur;
            tail = cur;
            ++x;
        }
        tail.next = null;
        reverseList(head);
        traverse(head);
    }

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        // 递归后继节点
        ListNode p = recur(cur.next, cur);
        // 修改节点引用指向
        cur.next = pre;
        // 返回反转链表的头节点
        return p;
    }

    public void traverse(ListNode head) {
        ListNode p = head.next;
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
    }

    /**
     * 迭代
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
