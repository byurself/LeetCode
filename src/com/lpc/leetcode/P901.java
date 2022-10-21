package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 股票价格跨度
 *
 * @author byu_rself
 * @date 2022/10/21 10:10
 */
public class P901 {
    int index;
    Deque<int[]> stack;

    public P901() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (price >= stack.peek()[1]) stack.pop();
        int ans = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return ans;
    }
}
