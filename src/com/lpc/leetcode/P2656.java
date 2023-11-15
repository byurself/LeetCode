package com.lpc.leetcode;

/**
 * K个元素的最大和
 *
 * @author byu_rself
 * @date 2023/11/15 9:25
 */
public class P2656 {

    public int maximizeSum(int[] nums, int k) {
        int x = -1;
        for (int num : nums) {
            x = Math.max(x, num);
        }
        return k * x + (k - 1) * k / 2;
    }
}
