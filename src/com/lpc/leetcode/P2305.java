package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 公平分发饼干
 *
 * @author byu_rself
 * @date 2024/2/4 10:57
 */
public class P2305 {

    @Test
    public void solution() {
        int[] cs = new int[]{8, 15, 10, 20, 8};
        int k = 2;
        System.out.println(distributeCookies(cs, k));
    }

    public int distributeCookies(int[] cs, int k) {
        int n = cs.length, mask = 1 << n, INF = 0x3f3f3f3f;
        int[] g = new int[mask];
        for (int s = 0; s < mask; s++) {
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += ((s >> i) & 1) == 1 ? cs[i] : 0;
            }
            g[s] = t;
        }
        int[][] f = new int[k + 10][mask];
        for (int i = 0; i <= k; i++) Arrays.fill(f[i], INF);
        f[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int s = 0; s < mask; s++) {
                for (int p = s; p != 0; p = (p - 1) & s) {
                    f[i][s] = Math.min(f[i][s], Math.max(f[i - 1][s - p], g[p]));
                }
            }
        }
        return f[k][mask - 1];
    }
}
