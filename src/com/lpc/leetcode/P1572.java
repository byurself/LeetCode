package com.lpc.leetcode;

/**
 * 矩阵对角线元素的和
 *
 * @author byu_rself
 * @date 2023/8/11 9:40
 */
public class P1572 {

    public int diagonalSum(int[][] mat) {
        int n = mat.length, ans = 0;
        for (int i = 0, j = n - 1; i < n; ++i, --j) {
            ans += mat[i][i] + mat[i][j];
            if (i == j) ans -= mat[i][i];
        }
        return ans;
    }
}
