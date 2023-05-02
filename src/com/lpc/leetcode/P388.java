package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 文件的最长绝对路径
 *
 * @author byu_rself
 * @date 2023/5/2 20:41
 */
public class P388 {

    public int lengthLongestPath(String input) {
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
