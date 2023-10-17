package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 等差数列划分II-子序列
 *
 * @author byu_rself
 * @date 2023/10/17 9:39
 */
public class P446 {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = (long) nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
