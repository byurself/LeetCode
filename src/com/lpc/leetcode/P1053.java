package com.lpc.leetcode;

/**
 * 交换一次的先前排列
 *
 * @author byu_rself
 * @date 2023/4/3 13:18
 */
public class P1053 {

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; --i) {
            if (arr[i - 1] > arr[i]) {
                for (int j = n - 1; j > i - 1; --j) {
                    if (arr[j] < arr[i - 1] && arr[j] != arr[j - 1]) {
                        int temp = arr[i - 1];
                        arr[i - 1] = arr[j];
                        arr[j] = temp;
                        return arr;
                    }
                }
            }
        }
        return arr;
    }
}
