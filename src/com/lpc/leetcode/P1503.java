package com.lpc.leetcode;

/**
 * 所有蚂蚁掉下来前的最后一刻
 *
 * @author byu_rself
 * @date 2023/7/31 10:07
 */
public class P1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int x : left) ans = Math.max(ans, x);
        for (int x : right) ans = Math.max(ans, n - x);
        return ans;
    }
}
