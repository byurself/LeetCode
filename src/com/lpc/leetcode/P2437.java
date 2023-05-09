package com.lpc.leetcode;

/**
 * 有效时间的数目
 *
 * @author byu_rself
 * @date 2023/5/9 8:49
 */
public class P2437 {

    public int countTime(String time) {
        return count(time.substring(0, 2), 24) * count(time.substring(3, 5), 60);
    }

    private int count(String time, int x) {
        int ans = 0;
        char[] s = time.toCharArray();
        for (int i = 0; i < x; ++i) {
            if ((s[0] == '?' || i / 10 == s[0] - '0') && (s[1] == '?' || i % 10 == s[1] - '0')) {
                ++ans;
            }
        }
        return ans;
    }
}
