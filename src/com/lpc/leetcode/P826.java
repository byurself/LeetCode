package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 安排工作以达到最大收益
 *
 * @author byu_rself
 * @date 2024/5/17 10:24
 */
public class P826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] index = new int[n][2];
        for (int i = 0; i < n; ++i) {
            index[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(index, (a, b) -> b[1] - a[1]);
        Arrays.sort(worker);
        int ans = 0, j = 0, maxProfit = 0;
        for (int w : worker) {
            while (j < n && index[j][0] < w) {
                maxProfit = Math.max(maxProfit, index[j++][1]);
            }
            ans += maxProfit;
        }
        return ans;
    }
}
