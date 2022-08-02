package com.lpc.leetcode;

import org.junit.Test;

/**
 * 排序的循环链表
 *
 * @author byu_rself
 * @date 2022/6/19 15:49
 */
public class Offer029 {

    @Test
    public void solution() {

    }

    public Node insert1(Node head, int x) {
        Node t = new Node(x);
        t.next = t;
        if (head == null) return t;
        Node ans = head;
        int min = head.val, max = head.val;
        while (head.next != ans) {
            head = head.next;
            min = Math.min(min, head.val);
            max = Math.max(max, head.val);
        }
        if (min == max) {
            t.next = ans.next;
            ans.next = t;
        } else {
            while (!(head.val == max && head.next.val == min)) head = head.next;
            while (!(x <= min || x >= max) && !(head.val <= x && x <= head.next.val)) head = head.next;
            t.next = head.next;
            head.next = t;
        }
        return ans;
    }

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
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }

    static class Node {
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
