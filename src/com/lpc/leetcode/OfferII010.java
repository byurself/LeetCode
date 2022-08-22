package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 k 的子数组
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
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) ans += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
