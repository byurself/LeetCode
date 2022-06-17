package com.lpc.leetcode;

import org.junit.Test;

/**
 * 复写零
 *
 * @author byu_rself
 * @date 2022/6/17 18:44
 */
public class P1089 {

    @Test
    public void solution() {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        for (int n : arr) {
            System.out.println(n);
        }
    }

    /**
     * 双指针
     *
     * @param arr 数组
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) j++;
            i++;
            j++;
        }
        i--;
        j--;
        while (i >= 0) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0 && --j >= 0) arr[j] = 0;
            i--;
            j--;
        }
    }

    /**
     * 数组后移
     *
     * @param arr 数组
     */
    public void duplicateZeros1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                if (i != arr.length - 1) {
                    arr[++i] = 0;
                }
            }
        }
    }
}
