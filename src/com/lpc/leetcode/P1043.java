package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 分隔数组以得到最大和
 *
 * @author byu_rself
 * @date 2023/4/19 14:52
 */
public class P1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i)
            for (int j = i, max = 0; j > i - k && j >= 0; --j) {
                max = Math.max(max, arr[j]);
                f[i + 1] = Math.max(f[i + 1], f[j] + (i - j + 1) * max);
            }
        return f[n];
    }

/*    int[] arr;
    int k;
    // Map<Integer, Integer> cache;
    int[] cache;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        this.arr = arr;
        this.k = k;
        cache = new int[n];
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if (cache[i] != 0) return cache[i];
        int ans = 0, max = 0;
        for (int j = i; j > i - k && j >= 0; --j) {
            max = Math.max(max, arr[j]);
            ans = Math.max(ans, dfs(j - 1) + (i - j + 1) * max);
        }
        return cache[i] = ans;
    }*/
}
