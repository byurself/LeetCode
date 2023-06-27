package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 删除一次得到子数组最大和
 *
 * @author byu_rself
 * @date 2023/6/27 15:57
 */
public class P1186 {

    public int maximumSum(int[] arr) {
        int n = arr.length, ans = Integer.MIN_VALUE;
        int[][] f = new int[n + 1][2];
        // 除 2 防止负数相加溢出
        Arrays.fill(f[0], Integer.MIN_VALUE / 2);
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], 0) + arr[i];
            f[i + 1][1] = Math.max(f[i][1] + arr[i], f[i][0]);
            ans = Math.max(ans, Math.max(f[i + 1][0], f[i + 1][1]));
        }
        return ans;
    }
}
