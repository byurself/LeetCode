package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 反转每对括号间的子串
 *
 * @author byu_rself
 * @date 2022/9/12 15:16
 */
public class P1190 {

    @Test
    public void solution() {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(c);
            else if (c >= 'a' && c <= 'z') stack.push(c);
            else {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                for (Character e : list) {
                    stack.push(e);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        builder.reverse();
        return builder.toString();
    }
}
