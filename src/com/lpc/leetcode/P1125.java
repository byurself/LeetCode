package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最小的必要团队
 *
 * @author byu_rself
 * @date 2023/4/8 14:55
 */
public class P1125 {
    private long all;
    private int[] mask;
    private long[][] cache;

    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        int m = reqSkills.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++i) map.put(reqSkills[i], i);
        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; ++i) {
            // 把 people[i] 压缩成一个二进制数 mask[i]
            for (String s : people.get(i)) {
                mask[i] |= 1 << map.get(s);
            }
        }
        int u = 1 << m;
        cache = new long[n][u];
        for (int i = 0; i < n; i++) Arrays.fill(cache[i], -1);
        all = (1L << n) - 1;
        long res = dfs(n - 1, u - 1);
        int[] ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < n; ++i) {
            if (((res >> i) & 1) > 0) ans[j++] = i;
        }
        return ans;
    }

    private long dfs(int i, int j) {
        if (j == 0) return 0;
        if (i < 0) return all;
        if (cache[i][j] != -1) return cache[i][j];
        long res = dfs(i - 1, j); // 不选 mask[i]
        long res2 = dfs(i - 1, j & ~mask[i]) | (1L << i); // 选 mask[i]
        return cache[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
    }
}
