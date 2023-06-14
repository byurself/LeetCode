package com.lpc.leetcode;

/**
 * 二进制字符串前缀一致的次数
 *
 * @author byu_rself
 * @date 2023/6/14 17:29
 */
public class P1375 {

    public int numTimesAllBlue(int[] flips) {
        int ans = 0, max = 0, n = flips.length;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, flips[i]);
            if (max == i + 1) ++ans;
        }
        return ans;
    }
}
