package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 0 和 1 个数相同的子数组
 *
 * @author byu_rself
 * @date 2022/8/22 14:24
 */
public class OfferII011 {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 1, 0};
        System.out.println(findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int ans = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else count--;
            if (map.containsKey(count)) {
                int preIndex = map.get(count);
                ans = Math.max(ans, i - preIndex);
            } else {
                map.put(count, i);
            }
        }
        return ans;
    }
}
