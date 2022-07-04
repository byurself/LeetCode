package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对差
 *
 * @author byu_rself
 * @date 2022/7/4 18:08
 */
public class P1200 {

    @Test
    public void solution() {
        int[] arr = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> arrList = minimumAbsDifference(arr);
        for (List<Integer> list : arrList) {
            System.out.println("[" + list.get(0) + ", " + list.get(1) + "]");
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int length = arr.length;
        List<List<Integer>> list = new ArrayList<>();
        if (length == 0) {
            return list;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++) {
            int t = arr[i + 1] - arr[i];
            if (t < min) {
                list.clear();
                min = t;
            }
            if (t == min) {
                List<Integer> numList = new ArrayList<>();
                numList.add(arr[i]);
                numList.add(arr[i + 1]);
                list.add(numList);
            }
        }
        return list;
    }
}
