package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 负二进制数相加
 *
 * @author byu_rself
 * @date 2023/5/18 9:26
 */
public class P1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr1.length - 1, j = arr2.length - 1, c = 0; i >= 0 || j >= 0 || c != 0; --i, --j) {
            int x = c;
            if (i >= 0) x += arr1[i];
            if (j >= 0) x += arr2[j];

            if (x >= 2) { // 逢二进负一
                x -= 2;
                c = -1;
            } else if (x >= 0) { // x = 0, 1,不进位
                c = 0;
            } else { // x = -1, 负二进制中， -1 == 11
                x = 1;
                c = 1;
            }
            list.add(x);
        }
        // 去除前导零
        while (list.size() > 1 && list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }
        int[] ans = new int[list.size()];
        // 将list反转
        for (int i = list.size() - 1, j = 0; i >= 0; --i, ++j) {
            ans[j] = list.get(i);
        }
        return ans;
    }
}
