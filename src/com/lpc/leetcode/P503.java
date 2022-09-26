package com.lpc.leetcode;

import java.util.*;

/**
 * 下一个更大元素 II
 *
 * @author byu_rself
 * @date 2022/9/26 11:40
 */
public class P503 {

    public int[] nextGreaterElements(int[] nums) {
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
