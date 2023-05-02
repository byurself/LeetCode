package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 强整数
 *
 * @author byu_rself
 * @date 2023/5/2 20:28
 */
public class P970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
