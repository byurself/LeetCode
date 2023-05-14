package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 距离相等的条形码
 *
 * @author byu_rself
 * @date 2023/5/14 11:19
 */
public class P1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int max = Arrays.stream(barcodes).max().getAsInt();
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; ++i) {
            index[i] = barcodes[i];
        }
        int[] cnt = new int[max + 1];
        for (int x : barcodes) ++cnt[x];
        Arrays.sort(index, (a, b) -> cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);
        int[] ans = new int[n];
        for (int j = 0, k = 0; k < 2; ++k) {
            for (int i = k; i < n; i += 2) {
                ans[i] = index[j++];
            }
        }
        return ans;
    }
}
