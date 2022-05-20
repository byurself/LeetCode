package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements
 *
 * @author byu_rself
 * @date 2022/5/19 12:27
 */
public class P453 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(minMoves(nums));
    }

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int count = 0;
        for (int num : nums) {
            count += num - min;
        }
        return count;
    }
}
