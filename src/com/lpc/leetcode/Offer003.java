package com.lpc.leetcode;

/**
 * 数组中重复的数字
 *
 * @author byu_rself
 * @date 2023/8/4 10:40
 */
public class Offer003 {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                ++i;
                continue;
            }
            if (nums[i] == nums[nums[i]]) return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
