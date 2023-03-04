package com.lpc.leetcode;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author byu_rself
 * @date 2023/3/4 14:27
 */
public class P153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
