package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 分糖果
 *
 * @author byu_rself
 * @date 2023/2/7 14:09
 */
public class P575 {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) {
            set.add(type);
        }
        int n = candyType.length / 2;
        return Math.min(n, set.size());
    }
}
