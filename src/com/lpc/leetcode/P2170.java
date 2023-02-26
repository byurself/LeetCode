package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 使数组变成交替数组的最少操作数
 *
 * @author byu_rself
 * @date 2023/2/26 14:24
 */
public class P2170 {

    private static final int N = (int) 1e5 + 10;
    private static int[] cnt1 = new int[N], cnt2 = new int[N];

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0, c = 0, d = 0;
        Arrays.fill(cnt1, 0);
        Arrays.fill(cnt2, 0);
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (i % 2 == 0) {
                ++cnt1[t];
                if (a == 0 || cnt1[t] > cnt1[a]) {
                    b = a;
                    a = t;
                } else if (t != a && (b == 0 || cnt1[t] > cnt1[b])) {
                    b = t;
                }
            } else {
                ++cnt2[t];
                if (c == 0 || cnt2[t] > cnt2[c]) {
                    d = c;
                    c = t;
                } else if (t != c && (d == 0 || cnt2[t] > cnt2[d])) {
                    d = t;
                }
            }
        }
        if (a != c) return n - cnt1[a] - cnt2[c];
        else return n - Math.max(cnt1[a] + cnt2[d], cnt2[c] + cnt1[b]);
    }
}
