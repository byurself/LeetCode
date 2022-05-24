package com.lpc.leetcode;

import org.junit.Test;

/**
 * Maximum Subarray
 *
 * @author byu_rself
 * @date 2022/5/24 9:32
 */
public class P53 {

    @Test
    public void solution() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
