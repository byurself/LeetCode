package com.lpc.leetcode;

import org.junit.Test;

/**
 * Remove Duplicates from Sorted Array II
 *
 * @author byu_rself
 * @date 2022/5/14 18:06
 */
public class P80 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3}; // 输入数组
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
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
