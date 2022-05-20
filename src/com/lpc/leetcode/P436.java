package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Find Right Interval
 *
 * @author byu_rself
 * @date 2022/5/20 15:24
 */
public class P436 {

    @Test
    public void solution() {
        int[][] intervals = new int[][]{{1, 4}, {2, 3}, {3, 4}};
        int[] rightInterval = findRightInterval(intervals);
        for (int i : rightInterval) {
            System.out.println(i);
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = target;
        }
        return result;
    }
}
