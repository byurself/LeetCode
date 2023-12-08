package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 出租车的最大盈利
 *
 * @author byu_rself
 * @date 2023/12/8 10:25
 */
public class P2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] group = new List[n + 1];
        for (int[] r : rides) {
            int start = r[0], end = r[1], tip = r[2];
            if (group[end] == null) {
                group[end] = new ArrayList<>();
            }
            group[end].add(new int[]{start, end - start + tip});
        }
        long[] f = new long[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = f[i - 1];
            if (group[i] != null) {
                for (int[] r : group[i]) {
                    f[i] = Math.max(f[i], f[r[0]] + r[1]);
                }
            }
        }
        return f[n];
    }

    /*List<int[]>[] group;
    long[] cache;

    public long maxTaxiEarnings(int n, int[][] rides) {
        cache = new long[n + 1];
        Arrays.fill(cache, -1);
        group = new List[n + 1];
        for (int[] r : rides) {
            int start = r[0], end = r[1], tip = r[2];
            if (group[end] == null) {
                group[end] = new ArrayList<>();
            }
            group[end].add(new int[]{start, end - start + tip});
        }
        return dfs(n);
    }

    private long dfs(int i) {
        if (i == 1) return 0;
        if (cache[i] != -1) return cache[i];
        // 不载在 i 下车的乘客
        long ans = dfs(i - 1);
        if (group[i] != null) {
            for (int[] r : group[i]) {
                // 载在 i 下车的乘客，剩余范围变成 [1, r[0]]
                ans = Math.max(ans, dfs(r[0]) + r[1]);
            }
        }
        return cache[i] = ans;
    }*/
}
