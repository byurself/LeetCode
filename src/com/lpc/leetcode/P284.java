package com.lpc.leetcode;

import java.util.Iterator;

/**
 * 顶端迭代器
 *
 * @author byu_rself
 * @date 2023/7/3 10:39
 */
public class P284 implements Iterator<Integer> {

    public P284() {
    }

    Iterator<Integer> iterator;
    Integer next;

    public P284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer ans = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
