package com.lpc.leetcode;

import org.junit.Test;

/**
 * 0～n-1中缺失的数字
 *
 * @author byu_rself
 * @date 2022/8/11 11:15
 */
public class Offer053II {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }

    /**
     * 二分
     */
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == mid) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
