package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出给定方程的正整数解
 *
 * @author byu_rself
 * @date 2023/2/18 22:14
 */
public class P1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y > 0) {
            int res = customfunction.f(x, y);
            if (res < z) ++x;
            else if (res > z) --y;
            else ans.add(List.of(x++, y--));
        }
        return ans;
    }

    private static class CustomFunction {
        int f(int x, int y) {
            return x + y;
        }
    }
}
