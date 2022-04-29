package com.lpc.leetcode;

import java.util.Arrays;

/**
 * @author byu_rself
 * @date 2022/4/28 11:39
 */
public class P905 {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 4};

        System.out.println(Arrays.toString(sortArrayByParity(array)));
    }

    private static int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }
        return result;
    }
}
