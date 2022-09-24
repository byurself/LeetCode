package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 最低加油次数
 *
 * @author byu_rself
 * @date 2022/9/24 19:31
 */
public class P871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length, x = 0, remain = startFuel, index = 0, ans = 0;
        while (x < target) {
            if (remain == 0) {
                if (!q.isEmpty()) {
                    remain += q.poll();
                    ans++;
                } else {
                    return -1;
                }
            }
            x += remain;
            remain = 0;
            while (index < n && stations[index][0] <= x) q.offer(stations[index++][1]);
        }
        return ans;
    }

    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length, idx = 0;
        int remain = startFuel, x = 0, ans = 0;
        while (x < target) {
            if (remain == 0) {
                if (!q.isEmpty() && ++ans >= 0) remain += q.poll();
                else return -1;
            }
            x += remain;
            remain = 0;
            while (idx < n && stations[idx][0] <= x) q.add(stations[idx++][1]);
        }
        return ans;
    }
}
