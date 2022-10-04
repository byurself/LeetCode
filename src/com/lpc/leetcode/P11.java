package com.lpc.leetcode;

import org.junit.Test;

/**
 * Container With Most Water
 *
 * @author byu_rself
 * @date 2022/5/15 14:33
 */
public class P11 {

    @Test
    public void solution() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            max = height[l] < height[r] ? Math.max(max, (r - l) * height[l++]) : Math.max(max, (r - l) * height[r--]);
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
