package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 不邻接植花
 *
 * @author byu_rself
 * @date 2023/4/15 15:38
 */
public class P1042 {

    @Test
    public void solution() {
        int n = 1;
        int[][] paths = new int[][]{};
        System.out.println(Arrays.toString(gardenNoAdj(n, paths)));
    }


    Map<Integer, List<Integer>> g = new HashMap<>();

    private void add(int a, int b) {
        g.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        for (int[] path : paths) {
            int x = path[0] - 1, y = path[1] - 1;
            add(x, y);
            add(y, x);
        }
        int[] ans = new int[n];
        for (int x = 0; x < n; ++x) {
            boolean[] used = new boolean[5];
            List<Integer> list = g.getOrDefault(x, new ArrayList<>());
            for (int y : list) used[ans[y]] = true;
            for (int c = 1; c < 5; ++c) {
                if (!used[c]) {
                    ans[x] = c;
                    break;
                }
            }
        }
        return ans;
    }

    /*public int[] gardenNoAdj1(int n, int[][] paths) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] path : paths) {
            int x = path[0] - 1, y = path[1] - 1;
            g[x].add(y);
            g[y].add(x);
        }
        int[] ans = new int[n];
        for (int x = 0; x < n; ++x) {
            boolean[] used = new boolean[5];
            for (int y : g[x]) used[ans[y]] = true;
            for (int c = 1; c < 5; ++c) {
                if (!used[c]) {
                    ans[x] = c;
                    break;
                }
            }
        }
        return ans;
    }*/
}
