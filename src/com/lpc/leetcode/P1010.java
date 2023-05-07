package com.lpc.leetcode;

/**
 * 总持续时间可被60整除的歌曲
 *
 * @author byu_rself
 * @date 2023/5/7 19:10
 */
public class P1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int ans = 0;
        for (int i : time) {
            i %= 60;
            int j = (60 - i) % 60;
            // 先查询再更新，题目要求 i < j
            ans += cnt[j];
            ++cnt[i];
        }
        return ans;
    }
}
