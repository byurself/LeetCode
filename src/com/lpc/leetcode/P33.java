package com.lpc.leetcode;

/**
 * 搜索旋转排序数组
 *
 * @author byu_rself
 * @date 2023/10/10 9:52
 */
public class P33 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= nums[0]) left = mid;
            else right = mid - 1;
        }
        if (target >= nums[0]) {
            left = 0;
        } else {
            left = left + 1;
            right = n - 1;
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return nums[right] == target ? right : -1;
    }
}
