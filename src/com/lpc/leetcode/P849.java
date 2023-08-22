package com.lpc.leetcode;

/**
 * 到最近的人的最大距离
 *
 * @author byu_rself
 * @date 2023/8/22 9:49
 */
public class P849 {

    public int maxDistToClosest(int[] seats) {
        int last = -1, n = seats.length, ans = 1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                if (last == -1) ans = Math.max(ans, i); // 坐左边
                else ans = Math.max(ans, (i - last) / 2); // 坐中间
                last = i;
            }
        }
        ans = Math.max(ans, n - last - 1); // 坐右边
        return ans;
    }
}
