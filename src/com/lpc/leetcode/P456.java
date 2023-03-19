package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 132 模式
 *
 * @author byu_rself
 * @date 2023/3/19 15:21
 */
public class P456 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length, k = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] < k) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
