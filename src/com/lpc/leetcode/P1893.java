package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 检查是否区域内所有整数都被覆盖
 *
 * @author byu_rself
 * @date 2022/9/19 14:34
 */
public class P1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        // 对差分数组进行处理
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        // 根据差分数组处理前缀和，可以原地做
        int[] sum = new int[52];
        for (int i = 1; i <= 51; i++) {
            sum[i] = sum[i - 1] + diff[i];
        }
        // 从left到right判断是否满足sum > 0
        for (int i = left; i <= right; i++) {
            if (sum[i] <= 0) return false;
        }
        return true;
    }

    public boolean isCovered3(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] range : ranges) {
            int l = Math.max(range[0], left);
            int r = Math.min(range[1], right);
            for (int i = l; i <= r; i++) {
                flag[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!flag[i]) return false;
        }
        return true;
    }

    public boolean isCovered2(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for (int[] range : ranges) {
            int l = range[0], r = range[1];
            if (l <= left && left <= r) left = r + 1;
        }
        return left > right;
    }

    public boolean isCovered1(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                flag[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!flag[i]) return false;
        }
        return true;
    }
}
