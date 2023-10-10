package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 移动机器人
 *
 * @author byu_rself
 * @date 2023/10/10 9:30
 */
public class P2731 {

    private static final int MOD = (int) 1e9 + 7;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (long) nums[i] + (s.charAt(i) == 'L' ? -d : d);
        }
        Arrays.sort(arr);
        long ans = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + i * arr[i] - sum) % MOD;
            sum += arr[i];
        }
        return (int) ans;
    }
}
