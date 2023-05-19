package com.lpc.leetcode;

/**
 * 活字印刷
 *
 * @author byu_rself
 * @date 2023/5/19 9:00
 */
public class P1079 {

    int[] cnt = new int[26];

    public int numTilePossibilities(String tiles) {
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs();
    }

    private int dfs() {
        int ans = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ++ans;
                --cnt[i];
                ans += dfs();
                ++cnt[i];
            }
        }
        return ans;
    }

}
