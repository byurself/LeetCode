package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水
 *
 * @author byu_rself
 * @date 2022/10/12 16:11
 */
public class P42 {

    @Test
    public void solution() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap4(height));
    }

    public int trap4(int[] height) {
        int sum = 0, cur = 0, n = height.length;
        int[] stack = new int[n];
        int tt = -1;
        while (cur < n) {
            while (tt > -1 && height[cur] > height[stack[tt]]) {
                int h = height[stack[tt--]];
                if (tt == -1) break;
                int l = cur - stack[tt] - 1;
                int min = Math.min(height[stack[tt]], height[cur]);
                sum += l * (min - h);
            }
            stack[++tt] = cur++;
        }
        return sum;
    }

    /**
     * 单调栈
     */
    public int trap(int[] height) {
        int sum = 0, cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) break;
                int l = cur - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[cur]);
                sum += l * (min - h);
            }
            stack.push(cur++);
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
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
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
