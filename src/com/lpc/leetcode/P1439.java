package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有序矩阵中的第k个最小数组和
 *
 * @author byu_rself
 * @date 2023/5/28 15:08
 */
public class P1439 {

    @Test
    public void solution() {
        int[][] mat = new int[][]{{1, 3, 11}, {2, 4, 6}};
        int k = 5;
        System.out.println(kthSmallest(mat, k));
    }

    public int kthSmallest(int[][] mat, int k) {
        int n = mat[0].length;
        List<Integer> pre = new ArrayList<>(k), cur = new ArrayList<>(n * k);
        pre.add(0);
        for (int[] row : mat) {
            cur.clear();
            for (int a : pre) {
                for (int b : row) {
                    cur.add(a + b);
                }
            }
            Collections.sort(cur);
            pre.clear();
            for (int i = 0; i < Math.min(k, cur.size()); ++i) {
                pre.add(cur.get(i));
            }
        }
        return pre.get(k - 1);
    }
}
