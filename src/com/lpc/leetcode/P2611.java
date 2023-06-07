package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 老鼠和奶酪
 *
 * @author byu_rself
 * @date 2023/6/7 8:49
 */
public class P2611 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0, n = reward1.length;
        for (int i = 0; i < n; ++i) {
            ans += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = 0; i < k; ++i) {
            ans += reward1[n - i - 1];
        }
        return ans;
    }
}
