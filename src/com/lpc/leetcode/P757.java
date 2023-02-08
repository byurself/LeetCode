package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 设置交集大小至少为2
 *
 * @author byu_rself
 * @date 2023/2/8 14:23
 */
public class P757 {

    @Test
    public void solution() {
        int[][] n = new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        System.out.println(intersectionSizeTwo(n));
    }

    public int intersectionSizeTwo(int[][] intervals) {
        // 右端点从小到大，左端点从大到小
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int l = -1, r = -1, ans = 0;
        for (int[] interval : intervals) {
            if (interval[0] > r) {
                l = interval[1] - 1;
                r = interval[1];
                ans += 2;
            } else if (interval[0] > l) {
                l = r;
                r = interval[1];
                ans++;
            }
        }
        return ans;
    }
}
