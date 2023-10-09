package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 最小和分割
 *
 * @author byu_rself
 * @date 2023/10/9 9:15
 */
public class P2578 {

    public int splitNum(int num) {
        int[] cnt = new int[10];
        int n = 0;
        while (num > 0) {
            ++cnt[num % 10];
            num /= 10;
            ++n;
        }
        int[] ans = new int[2];
        for (int i = 0, j = 0; i < n; ++i) {
            while (cnt[j] == 0) ++j;
            --cnt[j];
            ans[i & 1] = ans[i & 1] * 10 + j;
        }
        return ans[0] + ans[1];
    }

    /*public int splitNum(int num) {
        char[] s = Integer.toString(num).toCharArray();
        Arrays.sort(s);
        int[] ans = new int[2];
        for (int i = 0; i < s.length; ++i) {
            ans[i & 1] = ans[i & 1] * 10 + (s[i] - '0');
        }
        return ans[0] + ans[1];
    }*/
}
