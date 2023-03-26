package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 和相等的子数组
 *
 * @author byu_rself
 * @date 2023/3/26 20:05
 */
public class P2395 {

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; ++i) {
            if (!set.add(nums[i - 1] + nums[i])) return true;
        }
        return false;
    }
}
