package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 袋子里最少数目的球
 *
 * @author byu_rself
 * @date 2023/6/13 10:32
 */
public class P1760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = -1;
        for (int x : nums) {
            if (x > right) right = x;
        }
        while (left < right) {
            int mid = left + right >> 1;
            long s = 0;
            for (int x : nums) {
                s += (x - 1) / mid;
            }
            if (s <= maxOperations) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
