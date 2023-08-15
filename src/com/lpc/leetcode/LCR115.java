package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 序列重建
 *
 * @author byu_rself
 * @date 2023/8/15 10:21
 */
public class LCR115 {

    int N = (int) 1e4 + 10, M = N, idx;
    int[] he = new int[N], e = new int[M], ne = new int[M], in = new int[N];

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        ++in[b];
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Arrays.fill(he, -1);
        int n = nums.length;
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; ++i) add(sequence[i - 1], sequence[i]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            if (in[i] == 0) queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() != 1) return false; // 起始入度为0的点不止一个或单次拓展新产生的入度为0的点不止一个，即拓扑序不唯一
            int cur = queue.poll();
            if (nums[index++] != cur) return false;
            for (int i = he[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) queue.offer(j);
            }
        }
        return index == n;
    }
}
