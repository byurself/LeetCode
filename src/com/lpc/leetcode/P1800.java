package com.lpc.leetcode;

/**
 * 最大升序子数组和
 *
 * @author byu_rself
 * @date 2022/10/7 15:19
 */
public class P1800 {

    public int maxAscendingSum(int[] nums) {
        int length = nums.length, ans = nums[0], sum = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
