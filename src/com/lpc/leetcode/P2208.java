package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 将数组和减半的最少操作次数
 *
 * @author byu_rself
 * @date 2023/7/25 9:15
 */
public class P2208 {

    public int halveArray(int[] nums) {
        int ans = 0;
        PriorityQueue<Double> q = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0, newSum = 0;
        for (int num : nums) {
            q.offer((double) num);
            sum += num;
        }
        while (newSum < sum / 2) {
            double x = q.poll();
            newSum += x / 2;
            q.offer(x / 2);
            ++ans;
        }
        return ans;
    }
}
