package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 贴纸拼词
 *
 * @author byu_rself
 * @date 2022/5/14 17:20
 */
public class P691 {

    @Test
    public void solution() {
        String[] stickers = new String[]{"with", "example", "science"};
        String target = "thehat";
        System.out.println(minStickers(stickers, target));
    }

    String[] stickers;
    String target;
    int[] cache;
    int m;

    public int minStickers(String[] stickers, String target) {
        m = target.length();
        cache = new int[1 << m];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        this.stickers = stickers;
        this.target = target;
        int ans = dfs((1 << m) - 1);
        return ans <= m ? ans : -1;
    }

    private int dfs(int mask) {
        if (cache[mask] < 0) {
            int ans = m + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); ++i) {
                    ++cnt[sticker.charAt(i) - 'a'];
                }
                for (int i = 0; i < m; ++i) {
                    char c = target.charAt(i);
                    if (((mask >> i) & 1) == 1 && cnt[c - 'a'] > 0) {
                        cnt[c - 'a']--;
                        left ^= 1 << i;
                    }
                }
                if (left < mask) {
                    ans = Math.min(ans, dfs(left) + 1);
                }
            }
            cache[mask] = ans;
        }
        return cache[mask];
    }
}
