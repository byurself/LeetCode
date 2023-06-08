package com.lpc.leetcode;

/**
 * 有界数组中指定下标处的最大值
 *
 * @author byu_rself
 * @date 2023/6/8 9:03
 */
public class P1802 {

    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private long sum(long x, int n) {
        return x >= n ? (x + x - n + 1) * n / 2 : (x + 1) * x / 2 + n - x;
    }
}
