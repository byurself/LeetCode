package com.lpc.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 课程表III
 *
 * @author byu_rself
 * @date 2023/9/11 9:38
 */
public class P630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] course : courses) {
            int duration = course[0], lastDay = course[1];
            sum += duration;
            q.offer(duration);
            if (sum > lastDay) sum -= q.poll();
        }
        return q.size();
    }
}
