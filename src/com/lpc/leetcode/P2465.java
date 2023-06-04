package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 不同的平均值数目
 *
 * @author byu_rself
 * @date 2023/6/4 13:42
 */
public class P2465 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            set.add(nums[i] + nums[j]);
        }
        return set.size();
    }
}
