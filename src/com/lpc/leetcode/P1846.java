package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 减小和重新排列数组后的最大元素
 *
 * @author byu_rself
 * @date 2023/2/1 14:36
 */
public class P1846 {

    public int maximumElementAfterDecrementingAndRearranging1(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int a : arr) {
            cnt[Math.min(a, n)]++;
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) ++miss;
            else miss -= Math.min(cnt[i] - 1, miss); // miss 不会小于 0，故至多减去 miss 个元素
        }
        return n - miss;
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;
        }
        return arr[n - 1];
    }
}
