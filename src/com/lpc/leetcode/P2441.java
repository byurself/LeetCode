package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 与对应负数同时存在的最大正整数
 *
 * @author byu_rself
 * @date 2023/5/13 15:37
 */
public class P2441 {

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for (int num : nums) set.add(num);
        for (int x : set) {
            if (set.contains(-x)) ans = Math.max(ans, x);
        }
        return ans;
    }
}
