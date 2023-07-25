package com.lpc.leetcode;

/**
 * 自定义字符串排序
 *
 * @author byu_rself
 * @date 2023/7/25 9:46
 */
public class P791 {

    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char c = order.charAt(i);
            while (cnt[c - 'a']-- > 0) builder.append(c);
        }
        for (int i = 0; i < 26; ++i) {
            while (cnt[i]-- > 0) builder.append((char) (i + 'a'));
        }
        return builder.toString();
    }
}
