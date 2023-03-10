package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 使数组和能被 P 整除
 *
 * @author byu_rself
 * @date 2023/3/10 14:21
 */
public class P1590 {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sum[i] = (sum[i - 1] + nums[i - 1]) % p;
        }
        if (sum[n] == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; ++i) {
            map.put(sum[i], i);
            int j = map.getOrDefault((sum[i] - sum[n] + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < n ? ans : -1;
    }
}
