package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 最大矩形
 *
 * @author byu_rself
 * @date 2022/10/3 23:07
 */
public class P85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[] heights = new int[col];
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> stack = new ArrayDeque<>();
        // 确定右边界
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) r[stack.pop()] = i;
            stack.push(i);
        }
        stack.clear();
        // 确定左边界
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) l[stack.pop()] = i;
            stack.push(i);
        }
        for (int i = 0; i < n; ++i) {
            int height = heights[i], width = r[i] - l[i] - 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }

    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = matrix[i - 1][j - 1] == '0' ? 0 : sum[i - 1][j] + 1;
            }
        }
        int[] l = new int[n + 10], r = new int[n + 10];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            int[] cur = sum[i];
            Arrays.fill(l, 0);
            Arrays.fill(r, n + 1);
            Deque<Integer> stack = new ArrayDeque<>();
            // 确定右边界
            for (int j = 1; j <= n; j++) {
                while (!stack.isEmpty() && cur[stack.peek()] > cur[j]) r[stack.pop()] = j;
                stack.push(j);
            }
            stack.clear();
            // 确定左边界
            for (int j = n; j >= 1; j--) {
                while (!stack.isEmpty() && cur[stack.peek()] > cur[j]) l[stack.pop()] = j;
                stack.push(j);
            }
            for (int j = 1; j <= n; j++) {
                int height = cur[j], width = r[j] - l[j] - 1;
                ans = Math.max(ans, height * width);
            }
        }
        return ans;
    }
}
