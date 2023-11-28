package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计前中后队列
 *
 * @author byu_rself
 * @date 2023/11/28 11:27
 */
public class P1670 {

    Deque<Integer> left;
    Deque<Integer> right;

    public P1670() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    /**
     * 调整长度
     * 保证 0 <= right.size() - left.size() <= 1
     */
    private void balance() {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        } else if (right.size() > left.size() + 1) {
            left.offerLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) left.offerLast(val);
        else right.offerFirst(val);
    }

    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }

    public int popFront() {
        // 整个队列为空
        if (right.isEmpty()) return -1;
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (right.isEmpty()) return -1;
        if (left.size() == right.size()) return left.pollLast();
        return right.pollFirst();
    }

    public int popBack() {
        if (right.isEmpty()) return -1;
        int val = right.pollLast();
        balance();
        return val;
    }
}
