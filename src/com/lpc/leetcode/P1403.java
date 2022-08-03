package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author byu_rself
 * @date 2022/8/4 0:06
 */
public class P1403 {

    @Test
    public void solution() {
        int[] nums = new int[]{4, 3, 10, 9, 8};
        List<Integer> list = minSubsequence(nums);
        for (Integer n : list) {
            System.out.print(n + "\t");
        }
    }

    public List<Integer> minSubsequence(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int current = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            current += nums[i];
            list.add(nums[i]);
            if (sum - current < current) break;
        }
        return list;
    }
}
