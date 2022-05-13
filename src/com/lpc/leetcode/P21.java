package com.lpc.leetcode;

import org.junit.Test;

/**
 * Merge Two Sorted Lists
 *
 * @author byu_rself
 * @date 2022/5/13 10:20
 */
public class P21 {

    @Test
    public void solution() {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists1(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 迭代
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = new ListNode();
        ListNode p = listNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                p.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                p.next = listNode2;
                listNode2 = listNode2.next;
            }
            p = p.next;
        }
        // 合并后 listNode1 和 listNode2 最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可
        p.next = listNode1 == null ? listNode2 : listNode1;
        return listNode.next;
    }

    /**
     * 递归
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        } else if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoLists(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoLists(listNode1, listNode2.next);
            return listNode2;
        }
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
