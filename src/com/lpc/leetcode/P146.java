package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 *
 * @author byu_rself
 * @date 2022/9/8 10:03
 */
public class P146 {

    Map<Integer, Node> map = new HashMap<>();
    Node dummy = new Node(0, 0);
    int capacity;

    public P146(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        addFirst(node);
        if (map.size() > capacity) {
            Node backNode = dummy.prev;
            map.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node;
    }

    private void addFirst(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /*private HashMap<Integer, Node> map;
    private DoubleLinkedList cache;
    private int capacity;

    public P146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        // 将该key提升为最近使用的
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        // 情况一：原本已经有该key
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        // 情况二：原本没有，需要删除现有元素，再添加
        if (capacity == cache.size) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    *//**
     * 将key提升为最近使用
     *//*
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    *//**
     * 添加最近使用的元素
     *//*
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    *//**
     * 删除某一个key
     *//*
    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }

    *//**
     * 双向链表,新元素向链尾添加，则头节点为最久未使用节点
     *//*
    private static class DoubleLinkedList {
        // 头节点
        private Node head;
        // 尾节点
        private Node tail;
        // 元素个数
        private int size;

        public DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        *//**
     * 在尾部插入节点
     *
     * @param x 节点
     *//*
        private void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        *//**
     * 删除目标节点
     *
     * @param x 节点
     *//*
        private void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        *//**
     * 删除链表中的第一个节点，并返回该节点
     *
     * @return 第一个节点
     *//*
        private Node removeFirst() {
            if (head.next == tail) return null;
            Node first = head.next;
            remove(first);
            return first;
        }

        *//**
     * 返回链表长度
     *
     * @return 链表长度
     *//*
        private int size() {
            return size;
        }
    }

    *//**
     * 节点
     *//*
    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }*/
}
