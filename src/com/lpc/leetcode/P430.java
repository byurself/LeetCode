package com.lpc.leetcode;

/**
 * 扁平化多级双向链表
 *
 * @author byu_rself
 * @date 2023/11/3 16:44
 */
public class P430 {

    public Node flatten(Node head) {
        Node dummy = new Node();
        for (dummy.next = head; head != null; head = head.next) {
            if (head.child != null) {
                Node temp = head.next;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node cur = head;
                while (cur.next != null) cur = cur.next;
                cur.next = temp;
                if (temp != null) temp.prev = cur;
            }
        }
        return dummy.next;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
