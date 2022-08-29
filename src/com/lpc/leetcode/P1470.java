package com.lpc.leetcode;

import org.junit.Test;

/**
 * 重新排列数组
 *
 * @author byu_rself
 * @date 2022/8/29 13:09
 */
public class P1470 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;
        int[] ans = shuffle(nums, n);
        for (int num : ans) {
            System.out.print(num + "\t");
        }
    }

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
