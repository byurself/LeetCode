package com.lpc.leetcode;

/**
 * 最长湍流子数组
 *
 * @author byu_rself
 * @date 2023/6/2 10:04
 */
public class P978 {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, ans = 1;
        int[] f = new int[2];
        f[0] = f[1] = 1;
        for (int i = 1; i < n; ++i) {
            int up = f[0], down = f[1];
            f[0] = arr[i - 1] < arr[i] ? down + 1 : 1;
            f[1] = arr[i - 1] > arr[i] ? up + 1 : 1;
            ans = Math.max(ans, Math.max(f[0], f[1]));
        }
        return ans;
    }

    public int maxTurbulenceSize1(int[] arr) {
        int n = arr.length, ans = 1;
        // f[i][j]表示以i结尾，且结尾状态为j的最长湍流子数组长度(0：上升,1：下降)
        int[][] f = new int[n][2];
        f[0][0] = f[0][1] = 1;
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i][1] = 1;
            if (arr[i - 1] < arr[i]) f[i][0] = f[i - 1][1] + 1; // 上升
            else if (arr[i - 1] > arr[i]) f[i][1] = f[i - 1][0] + 1; // 下降
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }
}
