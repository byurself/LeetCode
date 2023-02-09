package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 最长数对链
 *
 * @author byu_rself
 * @date 2023/2/9 14:37
 */
public class P627 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 0, cur = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                cur = pair[1];
                res++;
            }
        }
        return res;
    }
}
