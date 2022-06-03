package com.lpc.leetcode;

import org.junit.Test;

/**
 * Consecutive Numbers Sum
 *
 * @author byu_rself
 * @date 2022/6/3 12:15
 */
public class P829 {

    @Test
    public void solution() {
        int n = 15;
        System.out.println(consecutiveNumbersSum(n));
    }

    public int consecutiveNumbersSum(int n) {
        int ans = 0; n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        return ans;
    }
}
