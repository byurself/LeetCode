package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 翻转卡片游戏
 *
 * @author byu_rself
 * @date 2023/8/2 9:23
 */
public class P822 {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int n = fronts.length, ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (fronts[i] == backs[i]) set.add(fronts[i]);
        }
        for (int x : fronts) {
            if (!set.contains(x)) ans = Math.min(ans, x);
        }
        for (int x : backs) {
            if (!set.contains(x)) ans = Math.min(ans, x);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
