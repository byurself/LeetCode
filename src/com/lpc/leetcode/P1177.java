package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建回文串检测
 *
 * @author byu_rself
 * @date 2023/6/15 13:26
 */
public class P1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] sum = new int[n + 1][26];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 26; ++j) {
                sum[i][j] = sum[i - 1][j];
            }
            ++sum[i][s.charAt(i - 1) - 'a'];
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2];
            int x = 0;
            for (int j = 0; j < 26; ++j) {
                // 奇数+1，偶数+0
                x += (sum[r + 1][j] - sum[l][j]) & 1;
            }
            ans.add(x / 2 <= k);
        }
        return ans;
    }
}
