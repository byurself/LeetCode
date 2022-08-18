package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 *
 * @author byu_rself
 * @date 2022/8/18 14:18
 */
public class OfferII004 {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, 100};
        System.out.println(singleNumber(nums));
    }

    /**
     * 依次确定每一个二进制位
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 哈希表
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer n : map.keySet()) {
            if (map.get(n) == 1) return n;
        }
        return -1;
    }
}
