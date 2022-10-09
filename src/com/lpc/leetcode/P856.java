package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 括号的分数
 *
 * @author byu_rself
 * @date 2022/10/9 10:38
 */
public class P856 {

    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(0);
            else {
                int cur = stack.pop();
                stack.push(stack.pop() + Math.max(cur * 2, 1));
            }
        }
        return stack.peek();
    }
}
