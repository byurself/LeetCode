package com.lpc.leetcode;

import org.junit.Test;

/**
 * 二维数组中的查找
 *
 * @author byu_rself
 * @date 2022/8/13 11:11
 */
public class Offer004 {

    @Test
    public void solution() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray1(matrix, 5));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, column = matrix[0].length;
        int i = 0, j = column - 1;
        // 从右上角开始搜索
        while (i < row && j >= 0) {
            int n = matrix[i][j];
            if (n == target) return true;
            else if (n < target) i++;
            else j--;
        }
        return false;
    }

    /**
     * 二分
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (matrix[i][mid] >= target) r = mid;
                else l = mid + 1;
            }
            if (matrix[i][r] == target) return true;
        }
        return false;
    }
}
