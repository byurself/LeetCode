package com.lpc.leetcode;

import java.util.*;

/**
 * 并行课程II
 *
 * @author byu_rself
 * @date 2023/7/28 9:39
 */
public class P1494 {

    int[] pre1, cache;
    int k, u;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.k = k;
        pre1 = new int[n];
        for (int[] e : relations) {
            // 先修课程集合
            pre1[e[1] - 1] |= 1 << (e[0] - 1);
        }
        u = (1 << n) - 1; // 全集
        cache = new int[1 << n];
        Arrays.fill(cache, -1);
        return dfs(u);
    }

    private int dfs(int i) {
        if (i == 0) return 0; // 空集
        if (cache[i] != -1) return cache[i];
        int i1 = 0, ci = u ^ i; // i 的补集
        for (int j = 0; j < pre1.length; j++) {
            // pre1[j] 在 i 的补集中，可以学（否则这学期一定不能学）
            if ((i >> j & 1) > 0 && (pre1[j] | ci) == ci) {
                i1 |= 1 << j;
            }
        }
        if (Integer.bitCount(i1) <= k) {
            // 如果个数小于 k，则可以全部学习，不再枚举子集
            return cache[i] = dfs(i ^ i1) + 1;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i1; j > 0; j = (j - 1) & i1) {
            // 枚举 i1 的子集 j
            if (Integer.bitCount(j) == k) {
                ans = Math.min(ans, dfs(i ^ j) + 1);
            }
        }
        return cache[i] = ans;
    }
}
