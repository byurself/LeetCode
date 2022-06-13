package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 高度检查器
 *
 * @author byu_rself
 * @date 2022/6/13 11:15
 */
public class P1051 {

    @Test
    public void solution() {
        int[] heights = new int[]{1, 2, 3, 4, 5};
        System.out.println(heightChecker(heights));
    }

    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != clone[i]) {
                count++;
            }
        }
        return count;
    }
}
