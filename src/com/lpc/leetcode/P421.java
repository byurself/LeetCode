package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中两个数的最大异或值
 *
 * @author byu_rself
 * @date 2023/2/21 11:04
 */
public class P421 {

    @Test
    public void solution() {
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }

    // 利用性质： a ^ b = c ，则 a ^ c = b，且 b ^ c = a
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
