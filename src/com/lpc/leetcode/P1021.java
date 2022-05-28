package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Remove Outermost Parentheses
 *
 * @author byu_rself
 * @date 2022/5/28 13:28
 */
public class P1021 {

    @Test
    public void solution() {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                builder.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return builder.toString();
    }
}
