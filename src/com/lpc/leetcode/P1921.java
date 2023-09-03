package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 消灭怪物的最大数量
 *
 * @author byu_rself
 * @date 2023/9/3 20:34
 */
public class P1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] times = new int[n];
        for (int i = 0; i < n; ++i) times[i] = (dist[i] - 1) / speed[i];
        Arrays.sort(times);
        for (int i = 0; i < n; ++i) {
            if (times[i] < i) {
                return i;
            }
        }
        return n;
    }
}
