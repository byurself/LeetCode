package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 *
 * @author byu_rself
 * @date 2022/10/4 12:18
 */
public class P581 {

    @Test
    public void solution() {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int left = 0, right = nums.length - 1;
        while (left <= right && nums[left] == arr[left]) ++left;
        while (left <= right && nums[right] == arr[right]) --right;
        return right - left + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1], max = nums[0];
        int left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) right = i;
            else max = nums[i];
            if (nums[n - i - 1] > min) left = n - i - 1;
            else min = nums[n - i - 1];
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
