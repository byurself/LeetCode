package com.lpc.leetcode;

/**
 * 搜索二维矩阵
 *
 * @author byu_rself
 * @date 2023/9/18 10:31
 */
public class P74 {

    int m, n;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int x = 0, y = n - 1;
        while (check(x, y) && matrix[x][y] != target) {
            if (matrix[x][y] > target) --y;
            else ++x;
        }
        return check(x, y) && matrix[x][y] == target;
    }

    private boolean check(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

/*    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (matrix[mid / n][mid % n] >= target) right = mid;
            else left = mid + 1;
        }
        return matrix[left / n][left % n] == target;
    }*/
}
