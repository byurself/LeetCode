package com.lpc.leetcode;

import org.junit.Test;

/**
 * Largest Triangle Area
 *
 * @author byu_rself
 * @date 2022/5/15 14:21
 */
public class P812 {

    @Test
    public void solution() {
        int[][] points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(largestTriangleArea(points));
    }

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    maxArea = Math.max(maxArea, triangleArea(
                            points[i][0], points[i][1],
                            points[j][0], points[j][1],
                            points[k][0], points[k][1]));
                }
            }
        }
        return maxArea;
    }

    /**
     * 三角形面积计算公式
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return
     */
    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
