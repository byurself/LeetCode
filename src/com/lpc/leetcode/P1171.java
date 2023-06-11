package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从链表中删去总和值为零的连续节点
 *
 * @author byu_rself
 * @date 2023/6/11 15:23
 */
public class P1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode p = dummy;
        while (p != null) {
            sum += p.val;
            map.put(sum, p);
            p = p.next;
        }
        sum = 0;
        p = dummy;
        while (p != null) {
            sum += p.val;
            p.next = map.get(sum).next;
            p = p.next;
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
