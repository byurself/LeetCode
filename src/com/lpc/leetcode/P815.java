package com.lpc.leetcode;

import java.util.*;

/**
 * 公交路线
 *
 * @author byu_rself
 * @date 2023/4/23 17:26
 */
public class P815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        Map<Integer, Set<Integer>> map = new HashMap<>(); // 某个车站可以进入的路线
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> stepMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int s : routes[i]) {
                if (s == source) { // 将经过起点的路线加入队列
                    queue.offer(i);
                    stepMap.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(s, new HashSet<>());
                set.add(i);
                map.put(s, set);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 当前所在的路线
            int step = stepMap.get(cur); // 进入该路线花费的距离
            for (int i : routes[cur]) {
                if (i == target) return step; // 当前路线包含终点，返回距离
                Set<Integer> set = map.get(i);
                if (set == null) continue;
                // 将由该车站发起的路线加入到队列
                for (Integer line : set) {
                    if (!stepMap.containsKey(line)) {
                        stepMap.put(line, step + 1);
                        queue.offer(line);
                    }
                }
            }
        }
        return -1;
    }
}
