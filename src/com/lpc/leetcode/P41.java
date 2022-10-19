package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的第一个正数
 *
 * @author byu_rself
 * @date 2022/10/20 0:47
 */
public class P41 {

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return length + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return nums.length + 1;
    }
}
