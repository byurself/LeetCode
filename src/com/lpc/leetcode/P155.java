package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈
 *
 * @author byu_rself
 * @date 2022/9/13 14:01
 */
public class P155 {

    private Deque<Integer> stack;
    private Deque<Integer> minStack; // 辅助栈，用于存取stack中的最小值

    public P155() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) minStack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
