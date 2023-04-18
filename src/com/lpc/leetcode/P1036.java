package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 逃离大迷宫
 *
 * @author byu_rself
 * @date 2023/4/18 8:30
 */
public class P1036 {

    int EDGE = (int) 1e6, MAX;
    Set<Long> set = new HashSet<>();
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] b : blocked) set.add(b[0] * (long) 1e6 + b[1]);
        int n = blocked.length;
        MAX = n * (n - 1) / 2;
        return bfs(source, target) && bfs(target, source);
    }

    private boolean bfs(int[] source, int[] target) {
        Set<Long> visited = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(source);
        visited.add(source[0] * (long) 1e6 + source[1]);
        while (!queue.isEmpty() && visited.size() <= MAX) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == target[0] && y == target[1]) return true; // 到达目标方格
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= EDGE || ny < 0 || ny >= EDGE) continue;
                long hash = nx * (long) 1e6 + ny;
                if (set.contains(hash)) continue; // 遇到障碍物
                if (visited.contains(hash)) continue; // 已经访问过
                queue.offer(new int[]{nx, ny});
                visited.add(hash);
            }
        }
        return visited.size() > MAX;
    }
}
