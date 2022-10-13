package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 *
 * @author byu_rself
 * @date 2022/10/12 16:11
 */
public class P42 {

    /**
     * 单调栈
     */
    public int trap(int[] height) {
        int sum = 0, cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (cur < height.length) {
            // 如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()]; // 出栈
                if (stack.isEmpty()) break;
                int distance = cur - stack.peek() - 1; // 两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[cur]);
                sum = sum + distance * (min - h);
            }
            stack.push(cur);
            cur++;
        }
        return sum;
    }

    /**
     * 双指针
     */
    public int trap3(int[] height) {
        int sum = 0, maxLeft = 0, maxRight = 0, length = height.length;
        int left = 1, right = length - 2;
        for (int i = 1; i < length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 动态规划
     */
    public int trap2(int[] height) {
        int sum = 0, length = height.length;
        int[] left = new int[length], right = new int[length];

        for (int i = 1; i < length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 模拟
     */
    public int trap1(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int cur = height[i];
            // 当前位置的左边最大值
            int left = -1;
            for (int j = i - 1; j >= 0; j--) left = Math.max(left, height[j]);
            if (left <= cur) continue;
            // 当前位置的右边边最大值
            int right = -1;
            for (int j = i + 1; j < n; j++) right = Math.max(right, height[j]);
            if (right <= cur) continue;

            ans += Math.min(left, right) - cur;
        }
        return ans;
    }
}
