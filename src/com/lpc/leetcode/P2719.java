package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 统计整数数目
 *
 * @author byu_rself
 * @date 2024/1/16 13:51
 */
public class P2719 {

    int[][] memo;
    char[] num1, num2;
    int minSum, maxSum;
    static int MOD = 1_000_000_007;

    public int count(String num1, String num2, int minSum, int maxSum) {
        int n = num2.length();
        num1 = "0".repeat(n - num1.length()) + num1; // 补前导零，和 num2 对齐
        memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        this.num1 = num1.toCharArray();
        this.num2 = num2.toCharArray();
        this.minSum = minSum;
        this.maxSum = maxSum;
        return dfs(0, 0, true, true);
    }

    private int dfs(int i, int sum, boolean limitLow, boolean limitHigh) {
        if (sum > maxSum) { // 非法
            return 0;
        }
        if (i == num2.length) {
            return sum >= minSum ? 1 : 0;
        }
        if (!limitLow && !limitHigh && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        int lo = limitLow ? num1[i] - '0' : 0;
        int hi = limitHigh ? num2[i] - '0' : 9;

        int res = 0;
        for (int d = lo; d <= hi; d++) { // 枚举当前数位填 d
            res = (res + dfs(i + 1, sum + d, limitLow && d == lo, limitHigh && d == hi)) % MOD;
        }

        if (!limitLow && !limitHigh) {
            memo[i][sum] = res;
        }
        return res;
    }
}
