package com.lpc.leetcode;

import java.util.Random;

/**
 * 非重叠矩形中的随机点
 *
 * @author byu_rself
 * @date 2022/6/9 13:32
 */
public class P497 {

    private int[][] rects;
    private int[] sum;
    private int n;
    private Random random;

    public P497(int[][] rects) {
        this.rects = rects;
        this.n = rects.length;
        this.sum = new int[n + 1];
        random = new Random();
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (rects[i - 1][2] - rects[i - 1][0] + 1) * (rects[i - 1][3] - rects[i - 1][1] + 1);
        }
    }

    public int[] pick() {
        int target = random.nextInt(sum[n]) + 1;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= target) r = mid;
            else l = mid + 1;
        }
        int[] cur = rects[r - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0];
        int y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }
}
