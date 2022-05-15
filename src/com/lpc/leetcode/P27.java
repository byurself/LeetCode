package com.lpc.leetcode;

import org.junit.Test;

/**
 * Remove Element
 *
 * @author byu_rself
 * @date 2022/5/16 0:30
 */
public class P27 {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int len = removeElement(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }
}
