package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 按列翻转得到最大值等行数
 *
 * @author byu_rself
 * @date 2023/5/15 9:39
 */
public class P1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            char[] s = new char[n];
            for (int i = 0; i < n; ++i) {
                // 将以1开头的行翻转
                s[i] = (char) (row[0] ^ row[i]);
            }
            ans = Math.max(ans, map.merge(String.valueOf(s), 1, Integer::sum));
        }
        return ans;
    }
}
