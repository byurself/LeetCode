package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 子数组范围和
 *
 * @author byu_rself
 * @date 2023/5/21 21:03
 */
public class P2104 {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long max = 0;
        for (int i = 0; i <= n; ++i) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int j = stack.pop();
                max += (long) nums[j] * (i - j) * (j - (stack.isEmpty() ? -1 : stack.peek()));
            }
            stack.push(i);
        }
        stack.clear();
        long min = 0;
        for (int i = 0; i <= n; ++i) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int j = stack.pop();
                min += (long) nums[j] * (i - j) * (j - (stack.isEmpty() ? -1 : stack.peek()));
            }
            stack.push(i);
        }
        return max - min;
    }

    public long subArrayRanges1(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < n; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }
}
