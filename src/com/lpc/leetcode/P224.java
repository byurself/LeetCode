package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器
 *
 * @author byu_rself
 * @date 2023/7/6 9:56
 */
public class P224 {

    int i;

    public int calculate(String s) {
        return cal(s);
    }

    private int cal(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, num = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (; i < n; ++i) {
            char c = cs[i];
            // 数字
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '(') { // 开始递归
                ++i;
                num = cal(s);
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
            if (c == ')') break; // 结束递归
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
