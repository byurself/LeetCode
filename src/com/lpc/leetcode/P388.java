package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 文件的最长绝对路径
 *
 * @author byu_rself
 * @date 2023/5/2 20:41
 */
public class P388 {

    @Test
    public void solution() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(input));
    }

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = input.length(), ans = 0;
        for (int i = 0; i < n; ) {
            int depth = 0;
            while (i < n && input.charAt(i) == '\t') {
                ++i;
                ++depth;
            }
            boolean isFile = false;
            int length = 0;
            while (i < n && input.charAt(i) != '\n') {
                ++length;
                if (input.charAt(i) == '.') isFile = true;
                ++i;
            }
            ++i;
            while (stack.size() > depth) stack.pop();
            if (!stack.isEmpty()) length += stack.peek() + 1;

            if (isFile) ans = Math.max(ans, length);
            else stack.push(length);
        }
        return ans;
    }

    public int lengthLongestPath1(String input) {
        int n = input.length(), pos = 0, ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (pos < n) {
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                ++pos;
                ++depth;
            }
            boolean isFile = false;
            int length = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') isFile = true;
                ++pos;
                ++length;
            }
            // 跳过当前换行符
            ++pos;
            while (stack.size() >= depth) stack.pop();
            if (!stack.isEmpty()) length += stack.peek() + 1;

            if (isFile) ans = Math.max(ans, length);
            else stack.push(length);
        }
        return ans;
    }
}
