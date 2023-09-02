package com.lpc.leetcode;

/**
 * 最多可以摧毁的敌人城堡数目
 *
 * @author byu_rself
 * @date 2023/9/2 19:21
 */
public class P2511 {

    public int captureForts(int[] forts) {
        int ans = 0, n = forts.length;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            if (forts[i] != 0) {
                while (j < n && forts[j] == 0) ++j;
                if (j < n && forts[i] + forts[j] == 0) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
            i = j;
        }
        return ans;
    }
}
