package com.lpc.leetcode;

/**
 * 两数之和II-输入有序数组
 *
 * @author byu_rself
 * @date 2023/7/8 17:52
 */
public class P167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) ++l;
            else if (sum > target) --r;
            else return new int[]{l + 1, r + 1};
        }
        return new int[]{};
    }
}
