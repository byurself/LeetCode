package com.lpc.leetcode;

import org.junit.Test;

/**
 * Remove Duplicates from Sorted Array
 *
 * @author byu_rself
 * @date 2022/5/14 17:42
 */
public class P26 {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 输入数组
        int[] expectedNums = new int[]{0, 1, 2, 3, 4}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1, i = 1;
        while (index < nums.length) {
            if (nums[index] != nums[index - 1]) {
                nums[i++] = nums[index];
            }
            index++;
        }
        return i;
    }

    /**
     * 通用解法(找出小于k个相同的数组)
     *
     * @param nums
     * @param k
     * @return
     */
    private int process(int[] nums, int k) {
        int idx = 0;
        for (int x : nums) {
            if (idx < k || nums[idx - k] != x) {
                nums[idx++] = x;
            }
        }
        return idx;
    }
}
