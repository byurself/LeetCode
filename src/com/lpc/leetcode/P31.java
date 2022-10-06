package com.lpc.leetcode;

/**
 * 下一个排列
 *
 * @author byu_rself
 * @date 2022/10/6 12:28
 */
public class P31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int length = nums.length;
        int firstIndex = -1, secondIndex = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, length - 1);
            return;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
