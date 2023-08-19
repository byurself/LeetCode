package com.lpc.leetcode;

/**
 * 旋转函数
 *
 * @author byu_rself
 * @date 2023/8/19 20:25
 */
public class P396 {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n * 2 + 1];
        for (int i = 1; i <= 2 * n; ++i) sum[i] = sum[i - 1] + nums[(i - 1) % n];
        for (int i = 1; i <= n; ++i) ans += nums[i - 1] * (i - 1);
        for (int i = n + 1, cur = ans; i < 2 * n; ++i) {
            cur += nums[(i - 1) % n] * (n - 1);
            cur -= sum[i - 1] - sum[i - n];
            if (cur > ans) ans = cur;
        }
        return ans;
    }
}
