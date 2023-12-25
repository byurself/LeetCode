package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 笨阶乘
 *
 * @author byu_rself
 * @date 2023/12/25 10:13
 */
public class P1006 {

    public int clumsy(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(n--);
        int index = 0; // * / + -
        while (n > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);
            } else if (index % 4 == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            ++index;
            --n;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
