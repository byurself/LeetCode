package com.lpc.leetcode;

/**
 * 灌溉花园的最少水龙头数目
 *
 * @author byu_rself
 * @date 2023/2/21 10:51
 */
public class P1326 {

    public int minTaps(int n, int[] ranges) {
        int[] maxRight = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int r = ranges[i];
            if (i > r) maxRight[i - r] = i + r; // 对于 i-r 来说，i+r 必然是它目前的最大值
            else maxRight[0] = Math.max(maxRight[0], i + r);
        }
        int ans = 0, curRight = 0, nextRight = 0;
        for (int i = 0; i < n; ++i) {
            nextRight = Math.max(nextRight, maxRight[i]);
            if (i == curRight) {
                if (i == nextRight) return -1;
                curRight = nextRight;
                ++ans;
            }
        }
        return ans;
    }
}
