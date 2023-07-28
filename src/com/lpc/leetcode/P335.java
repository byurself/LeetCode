package com.lpc.leetcode;

/**
 * 路径交叉
 *
 * @author byu_rself
 * @date 2023/7/28 10:14
 */
public class P335 {

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) return false;
        for (int i = 3; i < n; ++i) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) return true;
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2])
                return true;
            if (i >= 5 && distance[i - 1] <= distance[i - 3] && distance[i - 2] > distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3])
                return true;
        }
        return false;
    }
}
