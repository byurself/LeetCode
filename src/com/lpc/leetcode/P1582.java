package com.lpc.leetcode;

import org.junit.Test;

/**
 * 二进制矩阵中的特殊位置
 *
 * @author byu_rself
 * @date 2022/9/4 19:49
 */
public class P1582 {

    @Test
    public void solution() {
        int[][] mat = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println(numSpecial(mat));
    }

    public int numSpecial(int[][] mat) {
        int row = mat.length, column = mat[0].length, res = 0;
        int[] sumRow = new int[row];
        int[] sumColumn = new int[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sumRow[i] += mat[i][j];
                sumColumn[j] += mat[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 1 && sumRow[i] == 1 && sumColumn[j] == 1) res++;
            }
        }
        return res;
    }
}
