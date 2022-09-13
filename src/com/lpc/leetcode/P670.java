package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最大交换
 *
 * @author byu_rself
 * @date 2022/9/13 13:52
 */
public class P670 {

    @Test
    public void solution() {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }

    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int maxIndex;
        for (int i = 0; i < array.length; i++) {
            maxIndex = i;
            for (int j = array.length - 1; j >= i + 1; j--) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                char temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
                return Integer.parseInt(new String(array));
            }
        }
        return num;
    }
}
