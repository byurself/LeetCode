package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 统计最高分的节点数目
 *
 * @author byu_rself
 * @date 2023/4/15 16:34
 */
public class P2049 {

    static int N = (int) 1e5 + 10, M = N * 2;
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
    }
}
