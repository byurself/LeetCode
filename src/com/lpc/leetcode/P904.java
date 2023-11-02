package com.lpc.leetcode;

/**
 * 水果成篮
 *
 * @author byu_rself
 * @date 2022/10/17 11:20
 */
public class P904 {

    public int totalFruit(int[] fruits) {
        int n = fruits.length, ans = 0, total = 0;
        int[] cnt = new int[n + 1];
        for (int i = 0, j = 0; i < n; ++i) {
            if (++cnt[fruits[i]] == 1) ++total;
            while (total > 2) {
                if (--cnt[fruits[j++]] == 0) --total;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public int totalFruit1(int[] fruits) {
        int length = fruits.length, ans = 0, total = 0;
        int[] cnt = new int[length + 10];
        for (int i = 0, j = 0; i < length; ++i) {
            if (++cnt[fruits[i]] == 1) total++;
            while (total > 2) {
                if (--cnt[fruits[j++]] == 0) total--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
