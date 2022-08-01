package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 *
 * @author byu_rself
 * @date 2022/8/1 8:45
 */
public class Offer035 {
    /**
     * 拼接与拆分
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }

    /**
     * 哈希表
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Node p = head;
        Map<Node, Node> map = new HashMap<>();
        // 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        // 构建新链表的 next 和 random 指向
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
