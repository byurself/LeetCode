package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements II
 *
 * @author byu_rself
 * @date 2022/5/19 14:26
 */
public class P462 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 10, 2, 9};
        System.out.println(minMoves2(nums));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int num : nums) {
            count += Math.abs(num - nums[nums.length / 2]);
        }
        return count;
    }
}
