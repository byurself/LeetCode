package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * @author byu_rself
 * @date 2022/10/10 14:49
 */
public class P215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) q.offer(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (q.peek() < nums[i]) {
                q.poll();
                q.offer(nums[i]);
            }
        }
        return q.peek();
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) q.offer(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (q.peek() < nums[i]) {
                q.poll();
                q.offer(nums[i]);
            }
        }
        return q.peek();
    }
}
