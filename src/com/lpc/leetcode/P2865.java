package com.lpc.leetcode;

import java.util.List;

/**
 * 美丽塔I
 *
 * @author byu_rself
 * @date 2024/1/24 9:43
 */
public class P2865 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        int n = maxHeights.size();
        for (int i = 0; i < n; ++i) {
            int height = maxHeights.get(i);
            long t = height;
            for (int j = i - 1; j >= 0; --j) {
                height = Math.min(height, maxHeights.get(j));
                t += height;
            }
            height = maxHeights.get(i);
            for (int j = i + 1; j < n; ++j) {
                height = Math.min(height, maxHeights.get(j));
                t += height;
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
