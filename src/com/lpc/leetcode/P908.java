package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最小差值 I
 *
 * @author byu_rself
 * @date 2022/4/30 13:45
 */
public class P908 {

    @Test
    public void solution() {
        int[] nums = {0, 10};
        int k = 2;
        System.out.println(smallestRangeI(nums, k));
    }

    /**
     * 官方推荐
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        return maxNum - minNum <= 2 * k ? 0 : maxNum - minNum - 2 * k;
    }

    /**
     * 基础做法
     * @param nums
     * @param k
     * @return
     */
    /*public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        if (max - min > 2 * k) {
            max -= k;
            min += k;
            return max - min;
        } else {
            return 0;
        }
    }*/

}
