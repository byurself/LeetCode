package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 满足不等式的最大值
 *
 * @author byu_rself
 * @date 2023/7/21 9:54
 */
public class P1499 {

    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        // (xi, yi - xi)
        Deque<int[]> q = new ArrayDeque<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            while (!q.isEmpty() && q.peekFirst()[0] < x - k) q.pollFirst();
            if (!q.isEmpty()) {
                ans = Math.max(ans, x + y + q.peekFirst()[1]);
            }
            while (!q.isEmpty() && q.peekLast()[1] <= y - x) q.pollLast();
            q.offerLast(new int[]{x, y - x});
        }
        return ans;
    }
}
