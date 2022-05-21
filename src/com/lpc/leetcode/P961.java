package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * N-Repeated Element in Size 2N Array
 *
 * @author byu_rself
 * @date 2022/5/21 23:49
 */
public class P961 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 2, 3, 3};
        System.out.println(repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        // 不可能的情况
        return -1;
    }
}
