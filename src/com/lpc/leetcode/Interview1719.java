package com.lpc.leetcode;

import org.junit.Test;

/**
 * 消失的两个数字
 *
 * @author byu_rself
 * @date 2022/9/26 10:40
 */
public class Interview1719 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 8, 6, 3, 10, 9, 2, 5};
        int[] ans = missingTwo(nums);
        for (int n : ans) {
            System.out.println(n);
        }
    }

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, totalSum = (n * (1 + n)) >> 1;
        for (int x : nums) totalSum -= x;
        int sum = totalSum, t = totalSum >> 1;
        totalSum = (t * (1 + t)) >> 1;
        for (int x : nums) {
            if (x <= t) totalSum -= x;
        }
        return new int[]{totalSum, sum - totalSum};
    }
}
