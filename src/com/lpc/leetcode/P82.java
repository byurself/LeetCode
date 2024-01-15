package com.lpc.leetcode;

/**
 * 删除排序链表中的重复元素II
 *
 * @author byu_rself
 * @date 2024/1/15 9:19
 */
public class P82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), pre = dummy, cur = head;
        while (cur != null) {
            // cur 指向的节点值与 cur.next 指向的节点值相同，跳过
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                // 没有重复元素
                pre = cur;
            } else {
                // 存在重复元素
                pre.next = cur.next;
            }
            cur = cur.next;
        }
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
