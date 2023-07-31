package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 链表随机节点
 *
 * @author byu_rself
 * @date 2023/7/31 10:13
 */
public class P382 {

    List<Integer> list;
    Random random;

    public P382(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
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
