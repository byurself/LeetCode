package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 最多可以参加的会议数目II
 *
 * @author byu_rself
 * @date 2023/6/14 17:35
 */
public class P1751 {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i < n; ++i) {
            int p = search(events, i, events[i][0]);
            for (int j = 1; j <= k; ++j) {
                f[i + 1][j] = Math.max(f[i][j], f[p + 1][j - 1] + events[i][2]);
            }
        }
        return f[n][k];
    }

    // 返回 endDay < upper 的最大下标
    private int search(int[][] events, int right, int upper) {
        int left = -1;
        while (left + 1 < right) {
            int mid = left + right >> 1;
            if (events[mid][1] < upper) left = mid;
            else right = mid;
        }
        return left;
    }
}
