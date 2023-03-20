package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 至少有 1 位重复的数字
 *
 * @author byu_rself
 * @date 2023/3/20 13:38
 */
public class P1012 {

    char[] s;
    int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
        return n - f(0, 0, true, false);
    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) return isNum ? 1 : 0; // isNum为true，表示得到了一个合法数字
        if (!isLimit && isNum && dp[i][mask] != -1) return dp[i][mask];
        int ans = 0;
        if (!isNum) ans = f(i + 1, mask, false, false); // 可以跳过当前数位
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; ++d) {
            if ((mask >> d & 1) == 0) // d不在mask中
                ans += f(i + 1, mask | (1 << d), isLimit && d == up, true);
        }
        if (!isLimit && isNum) dp[i][mask] = ans;
        return ans;
    }
}
