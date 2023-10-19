package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 同积元组
 *
 * @author byu_rself
 * @date 2023/10/19 9:24
 */
public class P1726 {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int x = nums[i] * nums[j];
                map.merge(x, 1, Integer::sum);
            }
        }
        int ans = 0;
        for (int v : map.values()) {
            ans += v * (v - 1) / 2;
        }
        return ans << 3;
    }
}
