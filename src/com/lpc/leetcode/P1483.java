package com.lpc.leetcode;

/**
 * 树节点的第K个祖先
 *
 * @author byu_rself
 * @date 2023/6/12 8:48
 */
public class P1483 {

    int[][] p;
    int m;

    public P1483(int n, int[] parent) {
        m = 32 - Integer.numberOfLeadingZeros(n);
        p = new int[n][m];
        for (int i = 0; i < n; ++i) p[i][0] = parent[i];
        for (int i = 0; i < m - 1; ++i) {
            for (int x = 0; x < n; ++x) {
                int cur = p[x][i];
                p[x][i + 1] = cur < 0 ? -1 : p[cur][i];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < m; ++i) {
            // k的二进制从低到高第i位是1
            if (((k >> i) & 1) > 0) {
                node = p[node][i];
                if (node < 0) break;
            }
        }
        return node;
    }
}
