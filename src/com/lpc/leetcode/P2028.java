package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 找出缺失的观测数据
 *
 * @author byu_rself
 * @date 2023/6/26 9:50
 */
public class P2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, s = m + n;
        int total = s * mean; // 总和
        for (int roll : rolls) total -= roll;
        // n个元素的总和范围需在[n, 6 * n]
        if (total < n || total > 6 * n) return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans, total / n);
        int d = total - (total / n * n);
        for (int i = 0; d-- > 0; ++i) {
            ++ans[i];
        }
        return ans;
    }
}
