package com.lpc.leetcode;

import java.util.*;

/**
 * 受标签影响的最大值
 *
 * @author byu_rself
 * @date 2023/5/23 9:15
 */
public class P1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] index = new int[n][2];
        for (int i = 0; i < n; ++i) {
            index[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(index, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, cnt = 0;
        for (int i = 0; i < n && cnt < numWanted; ++i) {
            int value = index[i][0], label = index[i][1];
            if (map.getOrDefault(label, 0) < useLimit) {
                map.merge(label, 1, Integer::sum);
                ++cnt;
                ans += value;
            }
        }
        return ans;
    }
}
