package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最优除法
 *
 * @author byu_rself
 * @date 2023/2/6 21:16
 */
public class P553 {

    @Test
    public void solution() {
        int[] nums = new int[]{1000, 100, 10, 2};
        System.out.println(optimalDivision(nums));
    }

    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            builder.append(nums[i]);
            if (i + 1 < n) builder.append("/");
        }
        if (n > 2) {
            builder.insert(builder.indexOf("/") + 1, "(");
            builder.append(')');
        }
        return builder.toString();
    }
}
