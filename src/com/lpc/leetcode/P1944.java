package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 队列中可以看到的人数
 *
 * @author byu_rself
 * @date 2024/1/5 9:28
 */
public class P1944 {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length, tt = -1;
        int[] ans = new int[n], stack = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (tt > -1 && stack[tt] < heights[i]) {
                --tt;
                ans[i]++;
            }
            if (tt > -1) {
                ans[i]++;
            }
            stack[++tt] = heights[i];
        }
        return ans;
    }

    public int[] canSeePersonsCount1(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                ans[i]++;
            }
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            stack.push(heights[i]);
        }
        return ans;
    }
}
