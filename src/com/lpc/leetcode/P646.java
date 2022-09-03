package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最长数对链
 *
 * @author byu_rself
 * @date 2022/9/3 19:02
 */
public class P646 {

    @Test
    public void solution() {
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        int res = 0, cur = Integer.MIN_VALUE;
        // 按数对中的第二个数排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                cur = pair[1];
                res++;
            }
        }
        return res;
    }
}
