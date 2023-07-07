package com.lpc.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 过桥的时间
 *
 * @author byu_rself
 * @date 2023/7/7 9:09
 */
public class P2532 {

    public int findCrossingTime(int n, int k, int[][] time) {
        Arrays.sort(time, (a, b) -> a[0] + a[2] - b[0] - b[2]);
        PriorityQueue<int[]> workL = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> workR = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> waitL = new PriorityQueue<>((a, b) -> b[0] - a[0]); // 下标越大效率越低
        PriorityQueue<int[]> waitR = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = k - 1; i >= 0; --i) {
            waitL.offer(new int[]{i, 0});
        }

        int cur = 0;
        while (n > 0) {
            // 左边完成放箱
            while (!workL.isEmpty() && workL.peek()[1] <= cur) waitL.add(workL.poll());
            // 右边完成搬箱
            while (!workR.isEmpty() && workR.peek()[1] <= cur) waitR.add(workR.poll());
            if (!waitR.isEmpty()) {
                // 右边过桥
                int[] p = waitR.poll();
                cur += time[p[0]][2];
                p[1] = cur + time[p[0]][3];
                workL.offer(p); // 放箱
            } else if (!waitL.isEmpty()) {
                // 左边过桥
                int[] p = waitL.poll();
                cur += time[p[0]][0];
                p[1] = cur + time[p[0]][1];
                workR.offer(p); // 搬箱
                --n;
            } else if (workL.isEmpty()) {
                cur = workR.peek()[1]; // cur 过小，找个最小的放箱/搬箱完成时间来更新 cur
            } else if (workR.isEmpty()) {
                cur = workL.peek()[1];
            } else {
                cur = Math.min(workL.peek()[1], workR.peek()[1]);
            }
        }
        while (!workR.isEmpty()) {
            int[] p = workR.poll(); // 右边完成搬箱
            // 如果没有排队，直接过桥；否则由于无论谁先过桥，最终完成时间都一样，所以也可以直接计算
            cur = Math.max(p[1], cur) + time[p[0]][2];
        }
        return cur; // 最后一个过桥的时间
    }
}
