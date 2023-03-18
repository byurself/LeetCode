package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 下一个更大元素 II
 *
 * @author byu_rself
 * @date 2022/9/26 11:40
 */
public class P503 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; --i) {
            int cur = nums[i % n];
            while (!stack.isEmpty() && cur >= nums[stack.peek()]) stack.pop();
            ans[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }
        return ans;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                int index = stack.pop();
                ans[index] = num;
            }
            stack.push(i % n);
        }
        return ans;
    }
}
