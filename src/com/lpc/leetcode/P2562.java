package com.lpc.leetcode;

/**
 * 找出数组的串联值
 *
 * @author byu_rself
 * @date 2023/10/12 10:07
 */
public class P2562 {

    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            ans += Integer.parseInt(nums[i] + "" + nums[j]);
        }
        if (n % 2 == 1) ans += nums[n / 2];
        return ans;
    }
}
