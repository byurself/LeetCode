package com.lpc.leetcode;

/**
 * 统计各位数字都不同的数字个数
 *
 * @author byu_rself
 * @date 2023/12/20 10:15
 */
public class P357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10;
        for (int i = 2, last = 9; i <= n; ++i) {
            int cur = last * (10 - i + 1);
            ans += cur;
            last = cur;
        }
        return ans;
    }
}
