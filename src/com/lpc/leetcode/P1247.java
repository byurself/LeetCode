package com.lpc.leetcode;

/**
 * 交换字符使得字符串相同
 *
 * @author byu_rself
 * @date 2023/2/25 11:48
 */
public class P1247 {
    public int minimumSwap(String s1, String s2) {
        int[] cnt = new int[2];
        for (int i = 0, n = s1.length(); i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++cnt[s1.charAt(i) % 2];
            }
        }
        int d = cnt[0] + cnt[1];
        return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
    }
}
