package com.lpc.leetcode;

import org.junit.Test;

/**
 * Valid Boomerang
 *
 * @author byu_rself
 * @date 2022/6/8 11:23
 */
public class P1037 {

    @Test
    public void solution() {
        int[][] points = new int[][]{{1, 1}, {2, 3}, {3, 2}};
        System.out.println(isBoomerang(points));
    }

    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
