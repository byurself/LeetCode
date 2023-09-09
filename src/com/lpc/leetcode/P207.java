package com.lpc.leetcode;

import java.util.*;

/**
 * 课程表
 *
 * @author byu_rself
 * @date 2022/10/31 10:34
 */
public class P207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int i = queue.poll();
            --numCourses;
            for (int j : g[i]) {
                if (--in[j] == 0) queue.offer(j);
            }
        }
        return numCourses == 0;
    }

    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            list.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : list.get(pre)) {
                if (--indegrees[cur] == 0) queue.addLast(cur);
            }
        }
        return numCourses == 0;
    }*/
}
