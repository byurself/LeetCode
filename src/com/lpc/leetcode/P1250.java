package com.lpc.leetcode;

/**
 * 检查「好数组」
 *
 * @author byu_rself
 * @date 2023/2/15 15:16
 */
public class P1250 {

    public boolean isGoodArray(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = gcd(num, ans);
            if (ans == 1) break;
        }
        return ans == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
