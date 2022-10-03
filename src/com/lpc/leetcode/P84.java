package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author byu_rself
 * @date 2022/10/3 22:36
 */
public class P84 {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length, ans = 0;
        int[] l = new int[length], r = new int[length];
        Arrays.fill(l, -1);
        Arrays.fill(r, length);
        Deque<Integer> stack = new ArrayDeque<>();
        // 确定右边界
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) r[stack.pop()] = i;
            stack.push(i);
        }
        stack.clear();
        // 确定左边界
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) l[stack.pop()] = i;
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            int height = heights[i], width = r[i] - l[i] - 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }
}
