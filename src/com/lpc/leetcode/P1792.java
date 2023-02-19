package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 最大平均通过率
 *
 * @author byu_rself
 * @date 2023/2/19 10:27
 */
public class P1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double ans = 0;
        int n = classes.length;
        PriorityQueue<double[]> q = new PriorityQueue<>((a, b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double y = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(y, x);
        });
        for (int[] aClass : classes) {
            q.offer(new double[]{aClass[0], aClass[1]});
        }
        while (extraStudents-- > 0) {
            double[] cur = q.poll();
            q.offer(new double[]{cur[0] + 1, cur[1] + 1});
        }
        for (int i = 0; i < n; i++) {
            double[] t = q.poll();
            ans += t[0] / t[1];
        }
        return ans / n;
    }
}
