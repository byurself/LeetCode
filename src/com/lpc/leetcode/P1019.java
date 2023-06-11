package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 链表中的下一个更大节点
 *
 * @author byu_rself
 * @date 2023/4/10 20:56
 */
public class P1019 {

    @Test
    public void solution() {
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(5)));
        System.out.println(Arrays.toString(nextLargerNodes(head)));
    }

    int[] ans;
    Deque<Integer> stack;

    public int[] nextLargerNodes(ListNode head) {
        stack = new ArrayDeque<>();
        func(head, 0);
        return ans;
    }

    /**
     * 构造答案
     *
     * @param node 当前节点
     * @param n    链表长度
     */
    private void func(ListNode node, int n) {
        if (node == null) {
            ans = new int[n];
            return;
        }
        func(node.next, n + 1);
        while (!stack.isEmpty() && stack.peek() <= node.val) stack.pop();
        if (!stack.isEmpty()) ans[n] = stack.peek();
        stack.push(node.val);
    }

/*    int n;

    public int[] nextLargerNodes(ListNode head) {
        head = reverse(head);
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            int num = head.val;
            --n;
            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            if (!stack.isEmpty()) ans[n] = stack.peek();
            stack.push(num);
            head = head.next;
        }
        return ans;
    }

    */

    /**
     * 反转链表
     *//*
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            ++n;
        }
        return pre;
    }*/

    /*public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            int num = list.get(i);
            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            if (!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(num);
        }
        return ans;
    }*/

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
