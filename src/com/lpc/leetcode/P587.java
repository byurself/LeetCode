package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 安装栅栏
 *
 * @author byu_rself
 * @date 2023/3/30 10:50
 */
public class P587 {

    /**
     * 向量相减
     */
    private int[] subtraction(int[] a, int[] b) {
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    /**
     * 向量叉乘
     */
    private double crossMultiplication(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    /**
     * 向量 ab 转为 向量 ac 过程中扫过的面积
     */
    private double getArea(int[] a, int[] b, int[] c) {
        return crossMultiplication(subtraction(b, a), subtraction(c, a));
    }

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length, tt = 0;
        int[] stack = new int[n + 10];
        boolean[] visited = new boolean[n + 10];
        stack[++tt] = 0; // 不标记起点
        // 先按x坐标升序，再按y坐标升序
        Arrays.sort(trees, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        for (int i = 1; i < n; ++i) {
            int[] c = trees[i];
            while (tt >= 2) {
                int[] a = trees[stack[tt - 1]], b = trees[stack[tt]];
                if (getArea(a, b, c) > 0) visited[stack[tt--]] = false;
                else break;
            }
            stack[++tt] = i;
            visited[i] = true;
        }
        int size = tt;
        for (int i = n - 1; i >= 0; --i) {
            if (visited[i]) continue;
            int[] c = trees[i];
            while (tt > size) {
                int[] a = trees[stack[tt - 1]], b = trees[stack[tt]];
                if (getArea(a, b, c) > 0) --tt;
                else break;
            }
            stack[++tt] = i;
        }
        int[][] ans = new int[tt - 1][2];
        for (int i = 1; i < tt; ++i) {
            ans[i - 1] = trees[stack[i]];
        }
        return ans;
    }
}
