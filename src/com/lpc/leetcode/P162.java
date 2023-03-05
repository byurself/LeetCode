package com.lpc.leetcode;

/**
 * 寻找峰值
 *
 * @author byu_rself
 * @date 2023/3/5 14:29
 */
public class P162 {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
