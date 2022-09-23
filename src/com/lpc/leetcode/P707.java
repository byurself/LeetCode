package com.lpc.leetcode;

/**
 * 设计链表
 *
 * @author byu_rself
 * @date 2022/9/23 10:20
 */
public class P707 {

    private Node head;
    private Node tail;
    private int size;

    public P707() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        else if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            Node cur = getNode(index);
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if (node == null) return;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node cur;
        if (index + 1 < size - index) {
            cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        }
        return cur;
    }


    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
    }
}
