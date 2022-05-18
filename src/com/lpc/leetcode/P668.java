package com.lpc.leetcode;

import org.junit.Test;

/**
 * Kth Smallest Number in Multiplication Table
 *
 * @author byu_rself
 * @date 2022/5/18 10:49
 */
public class P668 {

    @Test
    public void solution() {
        int m = 3, n = 3, k = 5;
        System.out.println(findKthNumber(m, n, k));
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
