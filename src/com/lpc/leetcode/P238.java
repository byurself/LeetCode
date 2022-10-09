package com.lpc.leetcode;

/**
 * 除自身以外数组的乘积
 *
 * @author byu_rself
 * @date 2022/10/9 10:47
 */
public class P238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, p = 1, q = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = p;
            p *= nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            q *= nums[i];
            ans[i - 1] *= q;
        }
        return ans;
    }
}
