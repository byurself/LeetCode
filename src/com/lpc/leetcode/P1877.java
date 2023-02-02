package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 数组中最大数对和的最小值
 *
 * @author byu_rself
 * @date 2023/2/2 18:55
 */
public class P1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0, length = nums.length;
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            res = Math.max(nums[i] + nums[j], res);
        }
        return res;
    }
}
