package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长定差子序列
 *
 * @author byu_rself
 * @date 2023/2/16 20:05
 */
public class P1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int n : arr) {
            dp.put(n, dp.getOrDefault(n - difference, 0) + 1);
            ans = Math.max(ans, dp.get(n));
        }
        return ans;
    }
}
