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
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = (left + right) >> 1;
            long op = 0;
            for (int num : nums) {
                op += (num - 1) / mid;
            }
            if (op <= maxOperations) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
