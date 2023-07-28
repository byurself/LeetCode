package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 并行课程III
 *
 * @author byu_rself
 * @date 2023/7/28 9:22
 */
public class P2050 {

    @Test
    public void solution() {
        int n = 3;
        int[][] relations = new int[][]{{1, 3}, {2, 3}};
        int[] time = new int[]{3, 2, 5};
        System.out.println(minimumTime(n, relations, time));
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] in = new int[n];
        for (int[] e : relations) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            ++in[b];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        // f[i] 表示节点 i 的最早完成时间
        int[] f = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int v = in[i], t = time[i];
            if (v == 0) {
                queue.offer(i);
                f[i] = t;
                ans = Math.max(ans, t);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : g[i]) {
                f[j] = Math.max(f[j], f[i] + time[j]);
                ans = Math.max(ans, f[j]);
                if (--in[j] == 0) {
                    queue.offer(j);
                }
            }
        }
        return ans;
    }
}
