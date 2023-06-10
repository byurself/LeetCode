package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 比较字符串最小字母出现频次
 *
 * @author byu_rself
 * @date 2023/6/10 14:31
 */
public class P1170 {

    @Test
    public void solution() {
        String[] queries = new String[]{"bbb", "cc"};
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
        System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] cnt = new int[12];
        for (String word : words) ++cnt[f(word)];
        for (int i = 9; i >= 1; --i) {
            cnt[i] += cnt[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            String s = queries[i];
            ans[i] = cnt[f(s) + 1];
        }
        return ans;
    }

    private int f(String word) {
        int cnt = 0;
        char minC = 'z';
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c < minC) {
                minC = c;
                cnt = 1;
            } else if (minC == c) {
                ++cnt;
            }
        }
        return cnt;
    }
}
