package com.lpc.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 单线程CPU
 *
 * @author byu_rself
 * @date 2023/5/7 19:20
 */
public class P1834 {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] index = new int[n][3]; // {入队时间,执行时间,原任务编号}
        for (int i = 0; i < n; ++i) index[i] = new int[]{tasks[i][0], tasks[i][1], i};
        Arrays.sort(index, (a, b) -> a[0] - b[0]); // 按入队时间进行升序
        // 先按 执行时间 排序，再按 任务编号 排序
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });
        int time = 1, idx = 0, k = 0;
        while (idx < n) {
            // 当前任务满足入队时间要求则入队
            while (k < n && index[k][0] <= time) q.offer(index[k++]);
            if (q.isEmpty()) {
                // 直接跳至下个任务的入队时间
                time = index[k][0];
            } else {
                // 根据优先级出队，并跳到该任务完成时间点
                int[] cur = q.poll();
                ans[idx++] = cur[2];
                time += cur[1];
            }
        }
        return ans;
    }
}
