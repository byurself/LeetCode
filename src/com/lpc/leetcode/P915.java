package com.lpc.leetcode;

/**
 * 分割数组
 *
 * @author byu_rself
 * @date 2022/10/24 18:46
 */
public class P915 {

    public int partitionDisjoint(int[] nums) {
        int index = 0, max = nums[0], leftMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (leftMax > nums[i]) {
                index = i;
                leftMax = max;
            } else {
                max = Math.max(max, nums[i]);
            }
        }
        return index + 1;
    }
}
