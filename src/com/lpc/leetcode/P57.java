package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 *
 * @author byu_rself
 * @date 2023/8/28 9:18
 */
public class P57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1];
        boolean flag = false;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (newEnd < start) {
                if (!flag) {
                    ans.add(new int[]{newStart, newEnd});
                    flag = true;
                }
                ans.add(interval);
            } else if (end < newStart) {
                ans.add(interval);
            } else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }
        if (!flag) {
            ans.add(new int[]{newStart, newEnd});
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; ++i) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;
        return merge(newIntervals);
    }

    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int start = intervals[i][0], end = intervals[i][1];
            if (ans.get(ans.size() - 1)[1] < start) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], end);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
