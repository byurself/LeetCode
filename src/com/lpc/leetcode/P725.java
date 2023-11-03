package com.lpc.leetcode;

/**
 * 分隔链表
 *
 * @author byu_rself
 * @date 2023/11/3 16:15
 */
public class P725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            ++n;
        }
        ListNode[] ans = new ListNode[k];
        int groupSize = n / k, reminder = n % k;
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; ++i) {
            ans[i] = cur;
            int partSize = groupSize + (i < reminder ? 1 : 0);
            for (int j = 1; j < partSize; ++j) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans;
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
