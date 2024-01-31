package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * @author byu_rself
 * @date 2022/10/10 14:49
 */
public class P215 {

    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        return quickSelect(0, n - 1, n - k);
    }

    private int quickSelect(int left, int right, int k) {
        if (left == right) return nums[k];
        int x = nums[left + right >> 1], i = left - 1, j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        if (k <= j) return quickSelect(left, j, k);
        else return quickSelect(j + 1, right, k);
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest2(int[] nums, int k) {
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
