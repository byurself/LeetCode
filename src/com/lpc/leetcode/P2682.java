package com.lpc.leetcode;

/**
 * 找出转圈游戏输家
 *
 * @author byu_rself
 * @date 2023/8/16 11:28
 */
public class P2682 {

    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0, t = 1; !visited[i]; ++t) {
            visited[i] = true;
            ++cnt;
            i = (i + t * k) % n;
        }
        int[] ans = new int[n - cnt];
        for (int i = 0, j = 0; i < n; ++i) {
            if (!visited[i]) {
                ans[j++] = i + 1;
            }
        }
        return ans;
    }
}
