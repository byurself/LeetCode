package com.lpc.leetcode;

/**
 * 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 *
 * @author byu_rself
 * @date 2023/3/6 14:29
 */
public class P1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length, m = queries.length;
        boolean[] ans = new boolean[m];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int type = queries[i][0], day = queries[i][1] + 1, cnt = queries[i][2];
            long min = sum[type] / cnt + 1, max = sum[type + 1];
            ans[i] = min <= day && day <= max;
        }
        return ans;
    }
}
