package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 *
 * @author byu_rself
 * @date 2024/1/8 10:50
 */
public class P447 {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] p1 : points) {
            cnt.clear();
            for (int[] p2 : points) {
                int d = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                int c = cnt.getOrDefault(d, 0);
                ans += c * 2;
                cnt.put(d, c + 1);
            }
        }
        return ans;
    }
}
