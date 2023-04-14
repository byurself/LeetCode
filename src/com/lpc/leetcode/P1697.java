package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 检查边长度限制的路径是否存在
 *
 * @author byu_rself
 * @date 2023/4/14 13:05
 */
public class P1697 {

    int[] p;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int m = queries.length;
        Integer[] index = new Integer[m];
        for (int i = 0; i < m; ++i) index[i] = i;
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);
        boolean[] ans = new boolean[m];
        int j = 0;
        for (int i : index) {
            int a = queries[i][0], b = queries[i][1], limit = queries[i][2];
            while (j < edgeList.length && edgeList[j][2] < limit) {
                int u = edgeList[j][0], v = edgeList[j][1];
                union(u, v);
                ++j;
            }
            ans[i] = find(a) == find(b);
        }
        return ans;
    }
}
