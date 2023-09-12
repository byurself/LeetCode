package com.lpc.leetcode;

import java.util.*;

/**
 * 课程表IV
 *
 * @author byu_rself
 * @date 2023/9/12 9:15
 */
public class P1462 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] in = new int[n];
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            g[a].add(b);
            ++in[b];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) queue.offer(i);
        }
        boolean[][] f = new boolean[n][n];
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : g[i]) {
                f[i][j] = true;
                // 若 k 是 i 的先行课程，那么 k 也是 j 的先行课程
                for (int k = 0; k < n; ++k) {
                    f[k][j] |= f[k][i];
                }
                if (--in[j] == 0) queue.offer(j);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int i = query[0], j = query[1];
            ans.add(f[i][j]);
        }
        return ans;
    }

    public List<Boolean> checkIfPrerequisite1(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] f = new boolean[n][n];
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            f[a][b] = true;
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    f[i][j] |= f[i][k] && f[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int i = query[0], j = query[1];
            ans.add(f[i][j]);
        }
        return ans;
    }
}
