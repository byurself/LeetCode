package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 特殊数组的特征值
 *
 * @author byu_rself
 * @date 2022/9/12 14:44
 */
public class P1608 {

    @Test
    public void solution() {
        int[] nums = new int[]{3, 5};
        System.out.println(specialArray(nums));
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] >= length) return length;
        for (int i = 1; i < length; i++) {
            int res = length - i;
            if (nums[i] >= res && nums[i - 1] < res) return res;
        }
        return -1;
    }
}
