package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 0和1个数相同的子数组
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
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                int preIndex = map.get(sum);
                ans = Math.max(ans, i - preIndex);
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
