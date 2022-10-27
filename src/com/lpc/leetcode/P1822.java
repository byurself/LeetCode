package com.lpc.leetcode;

/**
 * 数组元素积的符号
 *
 * @author byu_rself
 * @date 2022/10/27 23:19
 */
public class P1822 {

    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) ans = -ans;
        }
        return ans;
    }
}
