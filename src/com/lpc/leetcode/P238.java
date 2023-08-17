package com.lpc.leetcode;

/**
 * 除自身以外数组的乘积
 *
 * @author byu_rself
 * @date 2022/10/9 10:47
 */
public class P238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 1, prod = 1; i <= n; ++i) {
            ans[i - 1] = prod;
            prod *= nums[i - 1];
        }
        for (int i = n, prod = 1; i >= 1; --i) {
            ans[i - 1] *= prod;
            prod *= nums[i - 1];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n], left = new int[n], right = new int[n];
        left[0] = right[n - 1] = 1;
        for (int i = 1; i < n; ++i) left[i] = left[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; --i) right[i] = right[i + 1] * nums[i + 1];
        for (int i = 0; i < n; ++i) ans[i] = left[i] * right[i];
        return ans;
    }

    public int[] productExceptSelf1(int[] nums) {
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
