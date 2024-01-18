package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 拿出最少数目的魔法豆
 *
 * @author byu_rself
 * @date 2024/1/18 9:52
 */
public class P2171 {

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for (int x : beans) sum += x;
        long ans = sum;
        int n = beans.length;
        for (int i = 0; i < n; ++i) {
            ans = Math.min(ans, sum - (long) beans[i] * (n - i));
        }
        return ans;
    }
}
