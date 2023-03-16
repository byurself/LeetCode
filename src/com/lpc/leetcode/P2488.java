package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计中位数为 K 的子数组
 *
 * @author byu_rself
 * @date 2023/3/16 14:51
 */
public class P2488 {

    public int countSubarrays(int[] nums, int k) {
        int n = nums.length, pos = 0;
        while (nums[pos] != k) ++pos;
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        for (int i = pos - 1, x = 0; i >= 0; --i) {
            x += nums[i] < k ? 1 : -1;
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = cnt.get(0) + cnt.getOrDefault(-1, 0);
        for (int i = pos + 1, x = 0; i < n; ++i) {
            x += nums[i] > k ? 1 : -1;
            ans += cnt.getOrDefault(x, 0) + cnt.getOrDefault(x - 1, 0);
        }
        return ans;
    }
}
