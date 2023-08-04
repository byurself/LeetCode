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
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
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
