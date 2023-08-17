package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * @author byu_rself
 * @date 2022/10/9 10:54
 */
public class P560 {

    public int subarraySum(int[] nums, int k) {
        int pre = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.merge(pre, 1, Integer::sum);
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s[j + 1] - s[i] == k) ans++;
            }
        }
        return ans;
    }

    public int subarraySum1(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }
}
