package com.lpc.leetcode;

/**
 * 零矩阵
 *
 * @author byu_rself
 * @date 2022/9/30 22:04
 */
public class Interview0108 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
