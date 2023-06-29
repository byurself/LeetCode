package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重构2行二进制矩阵
 *
 * @author byu_rself
 * @date 2023/6/29 9:17
 */
public class P1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> first = new ArrayList<>(), second = new ArrayList<>();
        for (int sum : colsum) {
            int a = 0, b = 0;
            if (sum == 2) {
                a = 1;
                b = 1;
                --upper;
                --lower;
            } else if (sum == 1) {
                if (upper >= lower) {
                    a = 1;
                    --upper;
                } else {
                    b = 1;
                    --lower;
                }
            }
            if (upper < 0 || lower < 0) break;
            first.add(a);
            second.add(b);
        }
        return upper == 0 && lower == 0 ? List.of(first, second) : new ArrayList<>();
    }
}
