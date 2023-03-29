package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 统计字典序元音字符串的数目
 *
 * @author byu_rself
 * @date 2023/3/29 11:45
 */
public class P1641 {

    public int countVowelStrings(int n) {
        int[] f = new int[]{1, 1, 1, 1, 1};
        for (int i = 0; i < n - 1; ++i) {
            int sum = 0;
            for (int j = 0; j < 5; ++j) {
                sum += f[j];
                f[j] = sum;
            }
        }
        return Arrays.stream(f).sum();
    }

    // 记忆化搜索
    /*private int[][] f;
    private int n;

    public int countVowelStrings(int n) {
        f = new int[n][5];
        this.n = n;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n) return 1;
        if (f[i][j] != 0) return f[i][j];
        int ans = 0;
        for (int k = j; k < 5; ++k) {
            ans += dfs(i + 1, k);
        }
        f[i][j] = ans;
        return ans;
    }*/
}
