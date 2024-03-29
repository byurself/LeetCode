package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计最高分的节点数目
 *
 * @author byu_rself
 * @date 2023/4/15 16:34
 */
public class P2049 {

    List<Integer>[] g;
    int[] f;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        f = new int[n];
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parents[i]].add(i);
        }
        dfs(0);
        long max = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            long cur = 1;
            for (int j : g[i]) {
                cur *= f[j];
            }
            if (i != 0) cur *= n - f[i];
            if (cur > max) {
                max = cur;
                ans = 1;
            } else if (cur == max) {
                ++ans;
            }
        }
        return ans;
    }

    private int dfs(int i) {
        int ans = 1;
        for (int j : g[i]) {
            ans += dfs(j);
        }
        return f[i] = ans;
    }

    /*static int N = (int) 1e5 + 10, M = N * 2;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] f = new int[N];
    int idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public int countHighestScoreNodes(int[] parents) {
        Arrays.fill(he, -1);
        int n = parents.length;
        for (int i = 1; i < n; ++i) add(parents[i], i);
        dfs(0);
        long max = 0;
        int ans = 0;
        for (int x = 0; x < n; ++x) {
            long cur = 1;
            for (int i = he[x]; i != -1; i = ne[i]) cur *= f[e[i]];
            if (x != 0) cur *= n - f[x];
            if (cur > max) {
                max = cur;
                ans = 1;
            } else if (cur == max) {
                ++ans;
            }
        }
        return ans;
    }

    private int dfs(int x) {
        int ans = 1;
        for (int i = he[x]; i != -1; i = ne[i]) ans += dfs(e[i]);
        return f[x] = ans;
    }*/
}
