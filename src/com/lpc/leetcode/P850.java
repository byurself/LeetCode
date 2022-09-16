package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 矩形面积 II
 *
 * @author byu_rself
 * @date 2022/9/16 15:52
 */
public class P850 {

    @Test
    public void solution() {
        int[][] rectangles = new int[][]{
                {0, 0, 2, 2},
                {1, 0, 2, 3},
                {1, 0, 3, 1}
        };
        System.out.println(rectangleArea(rectangles));
    }

    private static final int MOD = (int) 1e9 + 7;

    public int rectangleArea(int[][] rectangles) {
        List<Integer> list = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            list.add(rectangle[0]);
            list.add(rectangle[2]);
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1), b = list.get(i), len = b - a;
            if (len == 0) continue;
            List<int[]> lines = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                if (rectangle[0] <= a && b <= rectangle[2]) lines.add(new int[]{rectangle[1], rectangle[3]});
            }
            lines.sort((l1, l2) -> l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1]);
            long total = 0, l = -1, r = -1;
            for (int[] cur : lines) {
                if (cur[0] > r) {
                    total += r - l;
                    l = cur[0];
                    r = cur[1];
                } else if (cur[1] > r) {
                    r = cur[1];
                }
            }
            total += r - l;
            ans += total * len;
            ans %= MOD;
        }
        return (int) ans;
    }
}
