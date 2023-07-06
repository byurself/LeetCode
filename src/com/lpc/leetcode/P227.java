package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器II
 *
 * @author byu_rself
 * @date 2023/7/6 9:35
 */
public class P227 {

    @Test
    public void solution() {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        for (int i = 0; i < n; ++i) {
            char c = cs[i];
            // 数字
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            // 符号
            if (!(c >= '0' && c <= '9') && c != ' ' || i == n - 1) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
