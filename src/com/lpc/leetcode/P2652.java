package com.lpc.leetcode;

/**
 * 倍数求和
 *
 * @author byu_rself
 * @date 2023/10/17 9:30
 */
public class P2652 {

    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }
        return ans;
    }
}
