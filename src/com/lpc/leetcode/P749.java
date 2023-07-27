package com.lpc.leetcode;

import java.util.*;

/**
 * 隔离病毒
 *
 * @author byu_rself
 * @date 2023/7/27 9:44
 */
public class P749 {

    int[][] isInfected;
    int m, n, ans;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;

    public int containVirus(int[][] isInfected) {
        this.isInfected = isInfected;
        m = isInfected.length;
        n = isInfected[0].length;
        while (true) {
            int cnt = getCnt();
            if (cnt == 0) break;
            ans += cnt;
        }
        return ans;
    }

    private int getCnt() {
        visited = new boolean[m][n];
        int max = 0, ans = 0;
        // list1:每个连通块的点集   list2:每个连通块的候选感染点集
        List<Set<Integer>> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isInfected[i][j] == 1 && !visited[i][j]) {
                    // set1:当前连通块的点集   set2:当前连通块的候选感染点集
                    Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
                    int b = search(i, j, set1, set2), a = set2.size();
                    if (a > max) {
                        max = a;
                        ans = b;
                    }
                    list1.add(set1);
                    list2.add(set2);
                }
            }
        }
        for (int i = 0; i < list2.size(); ++i) {
            for (int loc : list2.get(i).size() == max ? list1.get(i) : list2.get(i)) {
                int x = loc / n, y = loc % n;
                isInfected[x][y] = list2.get(i).size() == max ? -1 : 1;
            }
        }
        return ans;
    }

    private int search(int i, int j, Set<Integer> set1, Set<Integer> set2) {
        int ans = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        set1.add(i * n + j);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1], loc = nx * n + y;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                if (isInfected[nx][ny] == 1) {
                    set1.add(loc);
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                } else if (isInfected[nx][ny] == 0) {
                    set2.add(loc);
                    ++ans;
                }
            }
        }
        return ans;
    }
}
