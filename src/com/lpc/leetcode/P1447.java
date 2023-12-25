package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最简分数
 *
 * @author byu_rself
 * @date 2023/12/25 10:33
 */
public class P1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
