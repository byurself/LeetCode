package com.lpc.leetcode;

import org.junit.Test;

/**
 * 优美的排列II
 *
 * @author byu_rself
 * @date 2022/9/8 9:49
 */
public class P667 {

    @Test
    public void solution() {
        int n = 6, k = 3;
        int[] ans = constructArray(n, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int index = 0;
        // 前面部分相差为1
        for (int i = 1; i < n - k; ++i) {
            ans[index++] = i;
        }
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            ans[index++] = i;
            if (i != j) {
                ans[index++] = j;
            }
        }
        return ans;
    }
}
