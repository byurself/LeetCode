package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 移动石子直到连续 II
 *
 * @author byu_rself
 * @date 2023/4/7 13:24
 */
public class P1040 {

    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        // 计算空位
        int s1 = stones[n - 2] - stones[0] - n + 2;
        int s2 = stones[n - 1] - stones[1] - n + 2;
        int maxMove = Math.max(s1, s2);
        // 没有空位
        if (s1 == 0 || s2 == 0) return new int[]{Math.min(2, maxMove), maxMove};
        int maxCnt = 0;
        for (int left = 0, right = 0; right < n; ++right) {
            while (stones[right] - stones[left] + 1 > n) ++left;
            maxCnt = Math.max(maxCnt, right - left + 1);
        }
        return new int[]{n - maxCnt, maxMove};
    }
}
