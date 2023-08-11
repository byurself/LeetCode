package com.lpc.leetcode;

/**
 * 循环有序列表的插入
 *
 * @author byu_rself
 * @date 2023/8/11 14:09
 */
public class LCR029 {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node cur = head, next = head.next;
        while (next != head) {
            if (insertVal >= cur.val && insertVal <= next.val) break;
            if (cur.val > next.val) {
                // 此时 cur 为循环链表的最大值， next 为循环列表的最小值
                if (insertVal > cur.val || insertVal < next.val) break;
            }
            cur = cur.next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }

    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
