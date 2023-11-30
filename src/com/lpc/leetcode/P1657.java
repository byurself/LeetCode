package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 确定两个字符串是否接近
 *
 * @author byu_rself
 * @date 2023/11/30 9:22
 */
public class P1657 {

    public boolean closeStrings(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n != m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[word1.charAt(i) - 'a'];
            ++cnt2[word2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            // 是否有相同的字母
            if ((cnt1[i] == 0) != (cnt2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        // 各字母出现的次数是否相同
        return Arrays.equals(cnt1, cnt2);
    }
}
