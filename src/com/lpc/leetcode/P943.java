package com.lpc.leetcode;

/**
 * 最短超级串
 *
 * @author byu_rself
 * @date 2023/7/21 10:12
 */
public class P943 {

    public String shortestSuperstring(String[] words) {
        int n = words.length, mask = 1 << n;
        int[][] g = new int[n][n];
        // g[i][j]表示words[i]的后缀与words[j]的前缀的重叠部分的长度
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                String a = words[i], b = words[j];
                int l1 = a.length(), l2 = b.length(), len = Math.min(l1, l2);
                for (int k = len; k >= 1; --k) {
                    if (a.substring(l1 - k).equals(b.substring(0, k))) {
                        g[i][j] = k;
                        break;
                    }
                }
            }
        }
        int[][] f = new int[mask][n], p = new int[mask][n];
        for (int s = 0; s < mask; ++s) {
            for (int i = 0; i < n; ++i) {
                if (((s >> i) & 1) == 0) continue;
                for (int j = 0; j < n; ++j) {
                    if (((s >> j) & 1) == 1) continue;
                    if (f[s | (1 << j)][j] <= f[s][i] + g[i][j]) {
                        f[s | (1 << j)][j] = f[s][i] + g[i][j];
                        p[s | (1 << j)][j] = i;
                    }
                }
            }
        }
        int max = f[mask - 1][0], idx = 0, last = -1, status = mask - 1;
        for (int i = 1; i < n; ++i) {
            if (max < f[mask - 1][i]) {
                max = f[mask - 1][i];
                idx = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (status != 0) {
            if (last == -1) ans.append(words[idx]);
            else ans.insert(0, words[idx].substring(0, words[idx].length() - g[idx][last]));
            last = idx;
            idx = p[status][idx];
            status ^= (1 << last);
        }
        return ans.toString();
    }
}
