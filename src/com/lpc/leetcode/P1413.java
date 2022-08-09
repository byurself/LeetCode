package com.lpc.leetcode;

import org.junit.Test;

/**
 * 逐步求和得到正数的最小值
 *
 * @author byu_rself
 * @date 2022/8/9 11:57
 */
public class P1413 {

    @Test
    public void solution() {
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums));
    }

    public int minStartValue(int[] nums) {
        int min = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return 1 - min;
    }

    public int minStartValue1(int[] nums) {
        int min = 0x3f3f3f3f, startValue = 1;
        for (int num : nums) {
            startValue += num;
            min = Math.min(min, startValue);
        }
        return min > 1 ? 1 : 2 - min;
    }
}
