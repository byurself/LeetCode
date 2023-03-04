package com.lpc.leetcode;

/**
 * 寻找旋转排序数组中的最小值 II
 *
 * @author byu_rself
 * @date 2023/3/4 15:20
 */
public class P154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else if (nums[mid] > nums[r]) l = mid + 1;
            else r--;
        }
        return nums[l];
    }
}
