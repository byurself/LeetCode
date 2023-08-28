package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 两个数组最小的异或值之和
 *
 * @author byu_rself
 * @date 2023/8/28 10:01
 */
public class P1879 {

    private static final int INF = 0x3f3f3f3f;

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length, mask = 1 << n;
        int[][] f = new int[n + 10][mask];
        for (int i = 0; i <= n; ++i) Arrays.fill(f[i], INF);
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int s = 0; s < mask; ++s) {
                if (getCnt(s, n) != i) continue;
                for (int j = 1; j <= n; ++j) {
                    if (((s >> (j - 1)) & 1) == 0) continue;
                    f[i][s] = Math.min(f[i][s], f[i - 1][s ^ (1 << (j - 1))] + (nums1[i - 1] ^ nums2[j - 1]));
                }
            }
        }
        return f[n][mask - 1];
    }

    private int getCnt(int s, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) ans += (s >> i) & 1;
        return ans;
    }
}
