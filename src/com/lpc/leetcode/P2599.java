package com.lpc.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 统计范围内的元音字符串数
 *
 * @author byu_rself
 * @date 2023/6/2 8:53
 */
public class P2599 {

    public int[] vowelStrings(String[] words, int[][] queries) {
        // Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            String word = words[i - 1];
            int length = word.length();
            boolean flag = set.contains(word.charAt(0)) && set.contains(word.charAt(length - 1));
            sum[i] = sum[i - 1] + (flag ? 1 : 0);
        }
        n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = sum[r + 1] - sum[l];
        }
        return ans;
    }
}
