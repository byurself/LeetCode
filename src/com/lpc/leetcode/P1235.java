package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 规划兼职工作
 *
 * @author byu_rself
 * @date 2022/10/22 12:37
 */
public class P1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        for (int i = 1; i <= n; i++) {
            int j = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[j] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    private int binarySearch(int[][] jobs, int r, int target) {
        int l = 0;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (jobs[mid][1] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
