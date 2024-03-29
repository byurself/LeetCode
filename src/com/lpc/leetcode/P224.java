package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器
 *
 * @author byu_rself
 * @date 2023/7/6 9:56
 */
public class P224 {

    @Test
    public void solution() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    int i, n;
    char[] cs;

    public int calculate(String s) {
        cs = s.toCharArray();
        n = cs.length;
        return cal();
    }

    private int cal() {
        int num = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (; i < n; ++i) {
            char c = cs[i];
            if (c == '(') { // 开始递归
                ++i;
                num = cal();
            } else if (c >= '0' && c <= '9') { // 数字
                num = num * 10 + (c - '0');
            }
            if (!(c >= '0' && c <= '9') && c != ' ' || i == n - 1) {
                // 符号
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
            // 结束递归
            if (c == ')') break;
        }
        int ans = 0;
        while (!stack.isEmpty()) ans += stack.pop();
        return ans;
    }

    /*int i;

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
    }*/
}
