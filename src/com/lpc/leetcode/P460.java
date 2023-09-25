package com.lpc.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU缓存
 *
 * @author byu_rself
 * @date 2022/9/9 0:24
 */
public class P460 {

    Map<Integer, Node> keyToNode = new HashMap<>();
    Map<Integer, Node> freqToDummy = new HashMap<>();
    int capacity;
    int minFreq;

    public P460(int capacity) {
        this.capacity = capacity;
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
        if (keyToNode.size() == capacity) {
            Node dummy = freqToDummy.get(minFreq);
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
            if (dummy.prev == dummy) {
                freqToDummy.remove(minFreq);
            }
        }
        node = new Node(key, value);
        keyToNode.put(key, node);
        addFirst(1, node);
        minFreq = 1;
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) return null;
        Node node = keyToNode.get(key);
        remove(node);
        Node dummy = freqToDummy.get(node.freq);
        // 移除空链表
        if (dummy.prev == dummy) {
            freqToDummy.remove(node.freq);
            if (minFreq == node.freq) {
                ++minFreq;
            }
        }
        addFirst(++node.freq, node);
        return node;
    }

    private void addFirst(int freq, Node x) {
        Node dummy = freqToDummy.computeIfAbsent(freq, k -> newList());
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    private Node newList() {
        Node dummy = new Node(0, 0);
        dummy.prev = dummy;
        dummy.next = dummy;
        return dummy;
    }

    private void remove(Node x) {
        x.next.prev = x.prev;
        x.prev.next = x.next;
    }

    private static class Node {
        int key, value, freq;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

/*    private Map<Integer, Node> map;  // 存储缓存的内容
    private Map<Integer, LinkedHashSet<Node>> frequencyMap; // 存储每个频次对应的双向链表
    private int size;
    private int capacity;
    private int min; // 存储当前最小频次

    public P460(int capacity) {
        map = new HashMap<>(capacity);
        frequencyMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            increaseFrequency(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                map.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    private void increaseFrequency(Node node) {
        // 从原frequency对应的链表里移除, 并更新min
        int frequency = node.frequency;
        LinkedHashSet<Node> set = frequencyMap.get(frequency);
        set.remove(node);
        if (frequency == min && set.size() == 0) {
            min = frequency + 1;
        }
        // 加入新frequency对应的链表
        node.frequency++;
        LinkedHashSet<Node> newSet = frequencyMap.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>());
        newSet.add(node);
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> set = frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = frequencyMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }

    private static class Node {
        private int key;
        private int value;
        private int frequency = 1;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }*/
}
