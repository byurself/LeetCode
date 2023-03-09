package com.lpc.leetcode;

/**
 * 子数组异或查询
 *
 * @author byu_rself
 * @date 2023/3/9 14:28
 */
public class P1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] sum = new int[n + 1], ans = new int[m];
        for (int i = 1; i <= n; ++i) {
            sum[i] ^= sum[i - 1] ^ arr[i - 1];
        }
        // queries(left, right) = sum[left] ^ sum[right + 1]
        for (int i = 0; i < m; ++i) {
            ans[i] = sum[queries[i][0]] ^ sum[queries[i][1] + 1];
        }
        return ans;
    }

    public int[] xorQueries1(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int l = queries[i][0], r = queries[i][1];
            int t = arr[l];
            for (int j = l + 1; j <= r; ++j) {
                t ^= arr[j];
            }
            ans[i] = t;
        }
        return ans;
    }
}
