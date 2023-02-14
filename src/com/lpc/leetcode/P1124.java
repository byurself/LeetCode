package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 表现良好的最长时间段
 *
 * @author byu_rself
 * @date 2023/2/14 12:04
 */
public class P1124 {

    @Test
    public void solution() {
        int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};
        System.out.println(longestWPI(hours));
    }

    public int longestWPI(int[] hours) {
        int n = hours.length, ans = 0;
        int[] s = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (s[stack.peek()] > s[i]) {
                stack.push(i);
            }
        }
        for (int r = n; r > 0; r--) {
            while (!stack.isEmpty() && s[stack.peek()] < s[r]) {
                ans = Math.max(ans, r - stack.pop());
            }
        }
        return ans;
    }
}
