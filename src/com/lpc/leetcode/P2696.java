package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 删除子串后的字符串最小长度
 *
 * @author byu_rself
 * @date 2024/1/10 10:05
 */
public class P2696 {

    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(' ');
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() - 1;
    }
}
