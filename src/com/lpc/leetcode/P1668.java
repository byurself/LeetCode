package com.lpc.leetcode;

/**
 * 最大重复子字符串
 *
 * @author byu_rself
 * @date 2023/11/28 15:51
 */
public class P1668 {


    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length(), ans = 0;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (i - m < 0) continue;
            if (sequence.substring(i - m, i).equals(word)) {
                f[i] = f[i - m] + 1;
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    /*public int maxRepeating(String sequence, String word) {
        for (int k = sequence.length() / word.length(); k >= 0; --k) {
            if (sequence.contains(word.repeat(k))) return k;
        }
        return 0;
    }*/
}
