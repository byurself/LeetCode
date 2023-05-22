package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 每日温度
 *
 * @author byu_rself
 * @date 2022/10/2 18:49
 */
public class P739 {

    @Test
    public void solution() {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n], stack = new int[n];
        int tt = -1;
        for (int i = 0; i < n; ++i) {
            while (tt > -1 && temperatures[i] > temperatures[stack[tt]]) {
                int index = stack[tt--];
                ans[index] = i - index;
            }
            stack[++tt] = i;
        }
        return ans;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
