package com.lpc.leetcode;

import java.util.*;

/**
 * 课程表II
 *
 * @author byu_rself
 * @date 2023/9/10 14:01
 */
public class P210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] in = new int[numCourses];
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            g[b].add(a);
            ++in[a];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] == 0) queue.offer(i);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            ans[idx++] = i;
            --numCourses;
            for (int j : g[i]) {
                if (--in[j] == 0) queue.offer(j);
            }
        }
        return numCourses == 0 ? ans : new int[0];
    }
}
