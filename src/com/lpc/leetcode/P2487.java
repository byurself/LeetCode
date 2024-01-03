package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从链表中移除节点
 *
 * @author byu_rself
 * @date 2024/1/3 11:08
 */
public class P2487 {

    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }

    /*public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new ArrayDeque<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                dummy.next = cur;
            } else {
                stack.peek().next = cur;
            }
            stack.push(cur);
        }
        return dummy.next;
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
