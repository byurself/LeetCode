package com.lpc.leetcode;

/**
 * 最短公共超序列
 *
 * @author byu_rself
 * @date 2023/3/28 10:31
 */
public class P1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) f[i][j] = f[i - 1][j - 1] + 1;
                else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = m, j = n; i > 0 || j > 0; ) {
            if (i == 0) builder.append(str2.charAt(--j));
            else if (j == 0) builder.append(str1.charAt(--i));
            else {
                if (f[i][j] == f[i - 1][j]) builder.append(str1.charAt(--i));
                else if (f[i][j] == f[i][j - 1]) builder.append(str2.charAt(--j));
                else {
                    builder.append(str1.charAt(--i));
                    --j;
                }
            }
        }
        return builder.reverse().toString();
    }
}
