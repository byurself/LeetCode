package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 卡车上的最大单元数
 *
 * @author byu_rself
 * @date 2023/2/5 11:56
 */
public class P1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int number = boxType[0];
            int unites = boxType[1];
            if (number < truckSize) {
                res += unites * number;
                truckSize -= number;
            } else {
                res += unites * truckSize;
                break;
            }
        }
        return res;
    }
}
