package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 带因子的二叉树
 *
 * @author byu_rself
 * @date 2023/8/29 9:04
 */
public class P823 {

    private static final int MOD = (int) 1e9 + 7;
    long[] cache;
    Map<Integer, Integer> map;
    int[] arr;

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        this.arr = arr;
        map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) map.put(arr[i], i);
        cache = new long[n];
        Arrays.fill(cache, -1);
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += dfs(i);
        }
        return (int) (ans % MOD);
    }

    private long dfs(int i) {
        if (cache[i] != -1) return cache[i];
        int x = arr[i];
        long ans = 1;
        for (int j = 0; j < i; ++j) { // x 的因子一定比 x 小
            int y = arr[j];
            if (x % y == 0 && map.containsKey(x / y)) {
                ans += dfs(j) * dfs(map.get(x / y));
            }
        }
        return cache[i] = ans;
    }

    // 动态规划
    public int numFactoredBinaryTrees1(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) map.put(arr[i], i);
        long ans = 0;
        long[] f = new long[n];
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            int x = arr[i];
            for (int j = 0; j < i; ++j) {
                int y = arr[j];
                if (x % y == 0 && map.containsKey(x / y)) {
                    f[i] += f[j] * f[map.get(x / y)];
                }
            }
            ans += f[i];
        }
        return (int) (ans % MOD);
    }
}
