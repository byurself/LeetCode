package com.lpc.leetcode;

/**
 * 下一个排列
 *
 * @author byu_rself
 * @date 2022/10/6 12:28
 */
public class P31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        // 从后往前找到第一个 (i, i + 1) 满足 nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) --i;
        if (i >= 0) {
            int j = n - 1;
            // 在 [i + 1, n) 中从后往前找到第一个元素 j，满足nums[i] < nums[j]
            while (j >= 0 && nums[j] <= nums[i]) --j;
            // 交换 nums[i] 与 nums[j]
            swap(nums, i, j);
        }
        // 此时区间 [i + 1, n) 必为降序，对该区间元素反转使其升序
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
