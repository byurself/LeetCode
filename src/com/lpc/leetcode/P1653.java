package com.lpc.leetcode;

/**
 * 使字符串平衡的最少删除次数
 *
 * @author byu_rself
 * @date 2023/3/6 14:05
 */
public class P1653 {

    public int minimumDeletions(String s) {
        int ans = 0, cntB = 0;
        for (char c : s.toCharArray())
            if (c == 'b') ++cntB;
            else ans = Math.min(ans + 1, cntB);
        return ans;
    }

    public int minimumDeletions1(String s) {
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            k += 'b' - s.charAt(i);
        }
        int ans = k;
        for (int i = 0; i < s.length(); i++) {
            // char c = s.charAt(i);
            // if (c == 'a') --k;
            // else ++k;
            k += (s.charAt(i) - 'a') * 2 - 1;
            ans = Math.min(ans, k);
        }
        return ans;
    }
}
