package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 从尾到头打印链表
 *
 * @author byu_rself
 * @date 2022/8/2 11:32
 */
public class Offer006 {

    @Test
    public void solution() {
        ListNode head = new ListNode(0), tail = head;
        int x = 1;
        while (x <= 5) {
            ListNode cur = new ListNode(x);
            tail.next = cur;
            tail = cur;
            ++x;
        }
        tail.next = null;
        int[] res = reversePrint(head.next);
        for (int n : res) {
            System.out.println(n + "\t");
        }
    }

    public int[] reversePrint1(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int n = stack.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reverse(head);
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void reverse(ListNode head) {
        if (head == null) return;
        reverse(head.next);
        list.add(head.val);
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
