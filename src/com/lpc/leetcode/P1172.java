package com.lpc.leetcode;

import java.util.*;

/**
 * 餐盘栈
 *
 * @author byu_rself
 * @date 2023/4/28 19:52
 */
public class P1172 {

    // 栈的大小
    private final int capacity;
    private final List<Deque<Integer>> stacks;
    // 最小堆，保存未满栈的下标
    private final PriorityQueue<Integer> idx;

    public P1172(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.idx = new PriorityQueue<>();
    }

    public void push(int val) {
        // 堆中都是越界下标，直接清空
        if (!idx.isEmpty() && idx.peek() >= stacks.size()) idx.clear();

        if (idx.isEmpty()) { // 所有栈都是满的
            Deque<Integer> st = new ArrayDeque<>();
            st.push(val);
            stacks.add(st);
            if (capacity > 1) idx.add(stacks.size() - 1);
        } else { // 还有未满栈
            Deque<Integer> st = stacks.get(idx.peek());
            st.push(val); // 入栈
            if (st.size() == capacity) idx.poll(); // 栈满了，从堆中去掉
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) return -1;
        Deque<Integer> st = stacks.get(index);
        if (st.size() == capacity) idx.add(index);
        int val = st.pop();
        // 去掉末尾的空栈（懒删除，堆中下标在 push 时处理）
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) stacks.remove(stacks.size() - 1);
        return val;
    }
}
