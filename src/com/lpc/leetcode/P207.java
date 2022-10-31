package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 课程表
 *
 * @author byu_rself
 * @date 2022/10/31 10:34
 */
public class P207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
    }
}
