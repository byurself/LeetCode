package com.lpc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 全O(1)的数据结构
 *
 * @author byu_rself
 * @date 2023/5/5 10:40
 */
public class P432 {

    Node head, tail;
    Map<String, Node> map;

    public P432() {
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            Node next = null;
            if (node.next.cnt == cnt + 1) {
                next = node.next;
            } else {
                next = new Node(cnt + 1);
                next.next = node.next;
                next.prev = node;
                node.next.prev = next;
                node.next = next;
            }
            next.set.add(key);
            map.put(key, next);
            clear(node);
        } else {
            Node node = null;
            if (head.next.cnt == 1) {
                node = head.next;
            } else {
                node = new Node(1);
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;
            }
            node.set.add(key);
            map.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.set.remove(key);
        int cnt = node.cnt;
        if (cnt == 1) {
            map.remove(key);
        } else {
            Node prev = null;
            if (node.prev.cnt == cnt - 1) {
                prev = node.prev;
            } else {
                prev = new Node(cnt - 1);
                prev.next = node;
                prev.prev = node.prev;
                node.prev.next = prev;
                node.prev = prev;
            }
            prev.set.add(key);
            map.put(key, prev);
        }
        clear(node);
    }

    public String getMaxKey() {
        Node node = tail.prev;
        for (String s : node.set) return s;
        return "";
    }

    public String getMinKey() {
        Node node = head.next;
        for (String s : node.set) return s;
        return "";
    }

    private void clear(Node node) {
        if (node.set.size() == 0) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private static class Node {
        Set<String> set = new HashSet<>();
        int cnt;
        Node next, prev;

        public Node(int cnt) {
            this.cnt = cnt;
        }
    }
}
