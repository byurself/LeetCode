package com.lpc.leetcode;

import org.junit.Test;

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
        int length = nums.length;
        int min = nums[length - 1], max = nums[0];
        int l = 0, r = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] < max) r = i;
            else max = nums[i];

            if (nums[length - i - 1] > min) l = length - i - 1;
            else min = nums[length - i - 1];
        }
        return r - l + 1;
    }
}
