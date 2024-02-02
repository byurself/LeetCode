package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 石子游戏VI
 *
 * @author byu_rself
 * @date 2024/2/2 16:57
 */
public class P1686 {

    public int stoneGameVI(int[] a, int[] b) {
        int n = a.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> a[j] + b[j] - a[i] - b[i]);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += i % 2 == 0 ? a[index[i]] : -b[index[i]];
        }
        return Integer.compare(diff, 0);
    }
}
