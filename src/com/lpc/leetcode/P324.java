package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 摆动排序 II
 *
 * @author byu_rself
 * @date 2022/6/28 19:56
 */
public class P324 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
