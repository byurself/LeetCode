package com.lpc.leetcode;

import org.junit.Test;

/**
 * 旋转数组的最小数字
 *
 * @author byu_rself
 * @date 2022/8/11 9:43
 */
public class Offer11 {

    @Test
    public void solution() {
        int[] numbers = new int[]{3, 4, 5, 1, 2};
        System.out.println(minArray(numbers));
    }

    public int minArray(int[] numbers) {
        int length = numbers.length;
        int l = 0, r = length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (numbers[mid] > numbers[r]) l = mid + 1;
            else if (numbers[mid] < numbers[r]) r = mid;
            else r--;
        }
        return numbers[r];
    }
}
