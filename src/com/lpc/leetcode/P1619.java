package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 删除某些元素后的数组均值
 *
 * @author byu_rself
 * @date 2022/9/14 0:29
 */
public class P1619 {

    @Test
    public void solution() {
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(trimMean(arr));
    }

    public double trimMean(int[] arr) {
        int length = arr.length;
        int size = (int) (length * 0.05);
        Arrays.sort(arr);
        double sum = 0;
        for (int i = size; i < length - size; i++) {
            sum += arr[i];
        }
        return sum / (length - 2 * size);
    }
}
