package com.lpc.leetcode;

/**
 * 得到 K 个黑块的最少涂色次数
 *
 * @author byu_rself
 * @date 2023/3/9 14:04
 */
public class P2379 {

    public int minimumRecolors(String blocks, int k) {
        int cnt = 0;
        char[] s = blocks.toCharArray();
        for (int i = 0; i < k; i++) {
            if (s[i] == 'W') ++cnt;
        }
        int ans = cnt;
        for (int i = k; i < s.length; i++) {
            if (s[i] == 'W') ++cnt;
            if (s[i - k] == 'W') --cnt;
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}
