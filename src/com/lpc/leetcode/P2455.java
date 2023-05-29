package com.lpc.leetcode;

/**
 * 可被三整除的偶数的平均值
 *
 * @author byu_rself
 * @date 2023/5/29 9:08
 */
public class P2455 {

    public int averageValue(int[] nums) {
        int sum = 0, cnt = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                ++cnt;
                sum += num;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
