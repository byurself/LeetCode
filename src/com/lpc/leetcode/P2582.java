package com.lpc.leetcode;

/**
 * 递枕头
 *
 * @author byu_rself
 * @date 2023/9/26 9:16
 */
public class P2582 {

    public int passThePillow(int n, int time) {
        int k = time / (n - 1);
        int mod = time % (n - 1);
        return (k & 1) == 1 ? n - mod : mod + 1;
    }

    public int passThePillow1(int n, int time) {
        int ans = 1, k = 1;
        while (time-- > 0) {
            ans += k;
            if (ans == 1 || ans == n) {
                k *= -1;
            }
        }
        return ans;
    }
}
