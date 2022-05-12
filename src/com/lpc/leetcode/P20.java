package com.lpc.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Valid Parentheses
 *
 * @author byu_rself
 * @date 2022/5/12 11:22
 */
public class P20 {

    @Test
    public void solution() {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        // 如果s长度为奇数，肯定无法匹配成功
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符c为右括号，则需要闭合
            if (map.containsKey(c)) {
                // 如果队列为空，或者队首元素不为与c相对应的左括号
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                // 出栈
                stack.pop();
            } else {
                // 当前字符c为左括号，入栈
                stack.push(c);
            }
        }
        // 如果栈为空，说明全部匹配完成，否则匹配失败
        return stack.isEmpty();
    }
}
