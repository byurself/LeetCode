package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 区间子数组个数
 *
 * @author byu_rself
 * @date 2023/5/21 21:35
 */
public class P795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            // 求nums[i]的左侧第一个大于该元素的下标l[i]
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] <= num) stack.pop();
            if (!stack.isEmpty()) l[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            // 求nums[i]的右侧第一个大于等于该元素的下标r[i]
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) stack.pop();
            if (!stack.isEmpty()) r[i] = stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left <= nums[i] && nums[i] <= right) {
                ans += (i - l[i]) * (r[i] - i);
            }
        }
        return ans;
    }

    // 对于区间[left, right]的问题，将其转换为[0, right]然后减去[0, left - 1]的问题
    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int x) {
        int cnt = 0, len = 0;
        for (int num : nums) {
            len = num > x ? 0 : len + 1;
            cnt += len;
        }
        return cnt;
    }
}
