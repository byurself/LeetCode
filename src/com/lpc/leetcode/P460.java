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

    private Map<Integer, Node> map;  // 存储缓存的内容
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
    }
}
