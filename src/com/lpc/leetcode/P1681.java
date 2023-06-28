package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最小不兼容性
 *
 * @author byu_rself
 * @date 2023/6/28 9:09
 */
public class P1681 {

    static final int INF = 1 << 30;

    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length, m = n / k;
        int[] g = new int[1 << n];
        Arrays.fill(g, -1);
        for (int i = 1; i < 1 << n; ++i) {
            if (Integer.bitCount(i) != m) continue;
            Set<Integer> set = new HashSet<>();
            int min = 20, max = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    if (!set.add(nums[j])) break;
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                }
            }
            if (set.size() == m) {
                g[i] = max - min;
            }
        }
        int[] f = new int[1 << n];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 0; i < 1 << n; ++i) {
            if (f[i] == INF) continue;
            Set<Integer> set = new HashSet<>();
            int mask = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 0 && !set.contains(nums[j])) {
                    set.add(nums[j]);
                    mask |= 1 << j;
                }
            }
            if (set.size() < m) continue;
            for (int j = mask; j > 0; j = (j - 1) & mask) {
                if (g[j] != -1) {
                    f[i | j] = Math.min(f[i | j], f[i] + g[j]);
                }
            }
        }
        return f[(1 << n) - 1] == INF ? -1 : f[(1 << n) - 1];
    }
}
