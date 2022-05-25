package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * @author byu_rself
 * @date 2022/5/25 19:28
 */
public class P1 {

    @Test
    public void solution() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        for (int n : twoSum) {
            System.out.print(n + "\t");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
