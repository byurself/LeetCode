package com.lpc.leetcode;

/**
 * 可被K整除的最小整数
 *
 * @author byu_rself
 * @date 2023/5/10 9:09
 */
public class P1015 {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int x = 1 % k;
        for (int i = 1; ; ++i) {
            if (x == 0) return i;
            x = (x * 10 + 1) % k;
        }
    }
}
