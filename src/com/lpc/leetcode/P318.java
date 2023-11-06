package com.lpc.leetcode;

/**
 * 最大单词长度乘积
 *
 * @author byu_rself
 * @date 2023/11/6 9:43
 */
public class P318 {

    public int maxProduct(String[] words) {
        int n = words.length, ans = 0;
        int[] mask = new int[n];
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
            for (int j = 0; j < i; ++j) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
