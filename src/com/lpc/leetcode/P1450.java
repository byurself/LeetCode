package com.lpc.leetcode;

import org.junit.Test;

/**
 * 在既定时间做作业的学生人数
 *
 * @author byu_rself
 * @date 2022/8/19 10:59
 */
public class P1450 {

    @Test
    public void solution() {
        int[] startTime = new int[]{1, 2, 3};
        int[] endTime = new int[]{3, 2, 7};
        int queryTime = 4;
        System.out.println(busyStudent(startTime, endTime, queryTime));
    }

    /**
     * 差分
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] c = new int[1010];
        for (int i = 0; i < startTime.length; i++) {
            c[startTime[i]]++;
            c[endTime[i] + 1]--;
        }
        for (int i = 1; i <= queryTime; i++) c[i] += c[i - 1];
        return c[queryTime];
    }

    public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) ans++;
        }
        return ans;
    }
}
