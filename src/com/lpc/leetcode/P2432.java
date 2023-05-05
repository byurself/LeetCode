package com.lpc.leetcode;

/**
 * 处理用时最长的那个任务的员工
 *
 * @author byu_rself
 * @date 2023/5/5 10:31
 */
public class P2432 {

    public int hardestWorker(int n, int[][] logs) {
        int ans = 0, max = 0, last = 0;
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            time -= last;
            if (max < time || (max == time && ans > id)) {
                max = time;
                ans = id;
            }
            last += time;
        }
        return ans;
    }
}
