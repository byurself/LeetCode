package com.lpc.leetcode;

import java.util.*;

/**
 * 到家的最少跳跃次数
 *
 * @author byu_rself
 * @date 2023/8/30 9:36
 */
public class P1654 {

    static final int n = 6000;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int f : forbidden) set.add(f);
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 1});
        boolean[][] visited = new boolean[n][2];
        visited[0][1] = true;
        for (int ans = 0; !queue.isEmpty(); ++ans) {
            for (int t = queue.size(); t > 0; --t) {
                int[] cur = queue.poll();
                int i = cur[0], k = cur[1];
                if (i == x) return ans;
                List<int[]> next = new ArrayList<>();
                next.add(new int[]{i + a, 1});
                if ((k & 1) == 1) {
                    next.add(new int[]{i - b, 0});
                }
                for (int[] e : next) {
                    int j = e[0];
                    k = e[1];
                    if (j >= 0 && j < n && !set.contains(j) && !visited[j][k]) {
                        queue.offer(new int[]{j, k});
                        visited[j][k] = true;
                    }
                }
            }
        }
        return -1;
    }
}
