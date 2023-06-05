package com.lpc.leetcode;

/**
 * 对数组执行操作
 *
 * @author byu_rself
 * @date 2023/6/5 8:58
 */
public class P2460 {

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int k = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < n; ++i) {
            nums[i] = 0;
        }
        return nums;
    }
}
