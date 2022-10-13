package com.lpc.leetcode;

/**
 * 最多能完成排序的块
 *
 * @author byu_rself
 * @date 2022/10/13 11:11
 */
public class P769 {

    public int maxChunksToSorted(int[] arr) {
        int ans = 1, max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}
