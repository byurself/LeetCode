package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 数字 1 的个数
 *
 * @author byu_rself
 * @date 2023/3/20 13:31
 */
public class P233 {

    char[] s;
    int[][] dp;

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][m];
        for (int i = 0; i < m; ++i) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    int f(int i, int cnt, boolean isLimit) {
        if (i == s.length) return cnt;
        if (!isLimit && dp[i][cnt] >= 0) return dp[i][cnt];
        int res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) // 枚举要填入的数字 d
            res += f(i + 1, cnt + (d == 1 ? 1 : 0), isLimit && d == up);
        if (!isLimit) dp[i][cnt] = res;
        return res;
    }
}
