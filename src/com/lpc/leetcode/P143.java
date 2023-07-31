package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 *
 * @author byu_rself
 * @date 2023/7/31 9:18
 */
public class P143 {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        // 找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分链表
        ListNode pre = null, cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 合并链表，此时 cur 指向左半边第一个节点，pre 指向右半边第一个节点
        cur = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = temp;
        }
    }

    /*public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            ++i;
            if (i == j) break;
            list.get(j).next = list.get(i);
            --j;
        }
        list.get(i).next = null;
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
