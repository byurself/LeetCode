package com.lpc.leetcode;

/**
 * 最长平衡子字符串
 *
 * @author byu_rself
 * @date 2023/11/8 9:11
 */
public class P2609 {

    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0, n = s.length(), k = 0;
        for (int i = 0; i < n; ) {
            int cnt0 = 0, cnt1 = 0;
            while (k < n && s.charAt(k) == '0') {
                ++k;
                ++cnt0;
            }
            while (k < n && s.charAt(k) == '1') {
                ++k;
                ++cnt1;
            }
            ans = Math.max(ans, Math.min(cnt0, cnt1) * 2);
            i = k;
        }
        return ans;
    }
}
