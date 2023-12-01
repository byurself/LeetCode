package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出叠涂元素
 *
 * @author byu_rself
 * @date 2023/12/1 9:26
 */
public class P2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] row = new int[m], col = new int[n];
        for (int k = 0; k < m * n; ++k) {
            int[] cur = map.get(arr[k]);
            int i = cur[0], j = cur[1];
            ++row[i];
            ++col[j];
            if (row[i] == n || col[j] == m) return k;
        }
        return -1;
    }
}
