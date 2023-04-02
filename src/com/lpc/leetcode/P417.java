package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 太平洋大西洋水流问题
 *
 * @author byu_rself
 * @date 2022/9/16 16:59
 */
public class P417 {

    @Test
    public void solution() {
        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> lists = pacificAtlantic(heights);
        lists.forEach(System.out::println);
    }

    int m, n;
    int[][] grid;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N = 200 * 200 + 10;
    int[] p1 = new int[N], p2 = new int[N];
    int total, S, T;

    private int find(int[] p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }

    private void union(int[] p, int a, int b) {
        p[find(p, a)] = p[find(p, b)];
    }

    private boolean query(int[] p, int a, int b) {
        return find(p, a) == find(p, b);
    }

    private int getIndex(int i, int j) {
        return i * n + j;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        grid = heights;
        m = grid.length;
        n = grid[0].length;
        total = m * n;
        S = total + 1;
        T = total + 2;
        for (int i = 0; i <= T; ++i) p1[i] = p2[i] = i;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = getIndex(i, j);
                if (i == 0 || j == 0) {
                    if (!query(p1, S, index)) dfs(p1, S, i, j);
                }
                if (i == m - 1 || j == n - 1) {
                    if (!query(p2, T, index)) dfs(p2, T, i, j);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = getIndex(i, j);
                if (query(p1, S, index) && query(p2, T, index)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void dfs(int[] p, int o, int x, int y) {
        union(p, o, getIndex(x, y));
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (query(p, o, getIndex(nx, ny)) || grid[nx][ny] < grid[x][y]) continue;
            dfs(p, o, nx, ny);
        }
    }

    // DFS
    /*
    int m, n;
    int[][] grid;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        grid = heights;
        m = grid.length;
        n = grid[0].length;
        boolean[][] res1 = new boolean[m][n], res2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (!res1[i][j]) dfs(i, j, res1);
                }
                if (i == m - 1 || j == n - 1) {
                    if (!res2[i][j]) dfs(i, j, res2);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, boolean[][] res) {
        res[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (res[nx][ny] || grid[nx][ny] < grid[x][y]) continue;
            dfs(nx, ny, res);
        }
    }*/

    // BFS
    /*
    int m, n;
    int[][] grid;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        grid = heights;
        m = grid.length;
        n = grid[0].length;
        Deque<int[]> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        boolean[][] res1 = new boolean[m][n], res2 = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    res1[i][j] = true;
                    q1.offer(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    res2[i][j] = true;
                    q2.offer(new int[]{i, j});
                }
            }
        }
        bfs(q1, res1);
        bfs(q2, res2);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private void bfs(Deque<int[]> q, boolean[][] res) {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1], t = grid[x][y];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (res[nx][ny] || grid[nx][ny] < t) continue;
                q.offer(new int[]{nx, ny});
                res[nx][ny] = true;
            }
        }
    }*/
}
