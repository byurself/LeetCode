package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 *
 * @author byu_rself
 * @date 2022/8/22 14:04
 */
public class OfferII010 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0, n = nums.length;
        for (int left = 0; left < n; ++left) {
            int sum = 0;
            for (int right = left; right >= 0; --right) {
                sum += nums[right];
                if (sum == k) ++ans;
            }
        }
        return ans;
    }

    public int subarraySum1(int[] nums, int k) {
        int ans = 0, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) ans += map.get(preSum - k);
            map.merge(preSum, 1, Integer::sum);
            // map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
