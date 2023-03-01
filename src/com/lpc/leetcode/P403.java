package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 青蛙过河
 *
 * @author byu_rself
 * @date 2023/3/1 13:04
 */
public class P403 {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) return false;
        boolean[][] f = new boolean[n + 1][n + 1];
        f[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j + 1) {
                    f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) return true;
        }
        return false;
    }


    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Boolean> cache = new HashMap<>();

    public boolean canCross1(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) return false;
        return dfs(stones, n, 1, 1);
    }

    /**
     * 判断能否跳到最后一块石子上
     *
     * @param stones 石子数组
     * @param n      石子长度
     * @param index  当前所在石子下标
     * @param k      上一次经过多少步跳到当前位置
     * @return 能否跳到最后一块石子
     */
    private boolean dfs(int[] stones, int n, int index, int k) {
        String key = index + "_" + k;
        if (cache.containsKey(key)) return cache.get(key);
        if (index == n - 1) return true;
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) continue;
            int next = stones[index] + k + i;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, n, map.get(next), k + i);
                cache.put(key, cur);
                if (cur) return true;
            }
        }
        cache.put(key, false);
        return false;
    }
}
