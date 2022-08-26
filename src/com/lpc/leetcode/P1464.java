package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数组中两元素的最大乘积
 *
 * @author byu_rself
 * @date 2022/8/26 17:21
 */
public class P1464 {

    @Test
    public void solution() {
        int[] nums = new int[]{3, 4, 5, 2};
        System.out.println(maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int a = -1, b = -1;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return (a - 1) * (b - 1);
    }

    /**
     * 排序
     */
    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 2] - 1) * (nums[n - 1] - 1);
    }
}
