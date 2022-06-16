package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中的 k-diff 数对
 *
 * @author byu_rself
 * @date 2022/6/16 20:42
 */
public class P532 {

    @Test
    public void solution() {
        int[] nums = new int[]{3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));
    }

    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }
}
