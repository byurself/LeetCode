package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 *
 * @author byu_rself
 * @date 2022/9/22 11:31
 */
public class P239 {

    @Test
    public void solution() {
        int[] nums = new int[]{7, 2, 4};
        int k = 2;
        int[] ans = maxSlidingWindow(nums, k);
        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        Deque<Integer> queue = new ArrayDeque<>();
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        for (int i = 0; i < length; i++) {
            // 队列内从大到小
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 窗口形成
            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[queue.peek()];
            }
        }
        return ans;
    }
}
