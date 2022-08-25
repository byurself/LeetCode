package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 *
 * @author byu_rself
 * @date 2022/8/25 19:55
 */
public class P658 {

    @Test
    public void solution() {
        int[] arr = new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        int k = 3, x = 5;
        System.out.println(findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        int l = 0, r = length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= x) r = mid;
            else l = mid + 1;
        }

        int i = l - 1, j = l;
        while (k-- > 0) {
            if (i < 0) j++;
            else if (j >= length) i--;
            else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) i--;
            else j++;
        }

        List<Integer> list = new ArrayList<>();
        for (int m = i + 1; m < j; m++) {
            list.add(arr[m]);
        }
        return list;
    }
}
